package com.intertect.usernameapp.dao;

import com.intertect.usernameapp.model.RestrictedWord;

public interface RestrictedWordDAO extends EntityDAO<RestrictedWord, Long> {
	
	public boolean containsRestrictedWord (String username);

}
