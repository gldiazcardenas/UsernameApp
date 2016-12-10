package com.intertect.usernameapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.intertect.usernameapp.dto.UsernameValidationResult;
import com.intertect.usernameapp.service.RestrictedWordService;
import com.intertect.usernameapp.service.UserService;
import com.intertect.usernameapp.service.UsernameGenerator;
import com.intertect.usernameapp.service.UsernameValidator;
import com.intertect.usernameapp.service.exception.ServiceException;

@Component
public class UsernameValidatorImpl implements UsernameValidator {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UsernameGenerator usernameGenerator;
	
	@Autowired
	private RestrictedWordService restrictedWordService;
	
	public UsernameValidationResult validate(String username) {
		if (username == null || username.trim().length() < 6) {
			throw new ServiceException("The username must be at least 6 characters long!");
		}
		
		UsernameValidationResult result = new UsernameValidationResult(true);
		
		if (userService.isTakenUsername(username)) {
			result.setValid(false);
			
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 14; j++) {
					String suggestedUsername = usernameGenerator.suggestUsername(username);
					
					if (!restrictedWordService.containsRestrictedWord(suggestedUsername)) {
						result.addSuggestedUsername(suggestedUsername);
					}
				}
				
				if (result.getSuggestedUsernamesSize() == 14) {
					break;
				}
			}
		}
		
		return result;
	}
	
}
