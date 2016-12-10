package com.intertect.usernameapp.service;

import com.intertect.usernameapp.model.RestrictedWord;

public interface RestrictedWordService extends EntityService<RestrictedWord, Long> {
	
	public boolean containsRestrictedWord (String username);

}
