package com.intertect.usernameapp.service.impl;

import org.springframework.stereotype.Component;

import com.intertect.usernameapp.service.UsernameGenerator;

@Component
public class UsernameGeneratorImpl implements UsernameGenerator {
	
	private static int consecutive = 1;
	
	@Override
	public String suggestUsername(String username) {
		// TODO Implement some strategy to generate better user names
		return username + "_" + consecutive++;
	}

}
