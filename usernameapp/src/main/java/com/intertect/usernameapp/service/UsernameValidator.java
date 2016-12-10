package com.intertect.usernameapp.service;

import com.intertect.usernameapp.dto.UsernameValidationResult;

public interface UsernameValidator {
	
	public UsernameValidationResult validate (String username);

}
