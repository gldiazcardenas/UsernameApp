package com.intertect.usernameapp.service.impl;

import java.util.ArrayList;
import java.util.List;

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
	
	public static final int MINIMUM_SIZE = 14;
	
	public static final int NUMBER_OF_ATTEMPTS = 3;
	
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
		
		if (restrictedWordService.containsRestrictedWord(username)) {
			throw new ServiceException("The username contains a restricted word!");
		}
		
		UsernameValidationResult result = new UsernameValidationResult(true);
		
		if (userService.isTakenUsername(username)) {
			List<String> suggestedUsernames = new ArrayList<String>();
			
			for (int i = 0; i < NUMBER_OF_ATTEMPTS; i++) {
				for (int j = 0; j < MINIMUM_SIZE; j++) {
					String suggested = usernameGenerator.suggestUsername(username);
					
					if (!restrictedWordService.containsRestrictedWord(suggested) && 
						!userService.isTakenUsername(suggested) && 
						!suggestedUsernames.contains(suggested)) {
						
						suggestedUsernames.add(suggested);
					}
				}
				
				if (suggestedUsernames.size() == MINIMUM_SIZE) {
					break;
				}
			}
			
			result.setValid(false);
			result.setSuggestedUsernames(suggestedUsernames);
		}
		
		return result;
	}
	
}
