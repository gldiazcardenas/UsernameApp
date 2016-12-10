package com.intertect.usernameapp.dao.impl;

import org.springframework.stereotype.Repository;

import com.intertect.usernameapp.dao.RestrictedWordDAO;
import com.intertect.usernameapp.model.RestrictedWord;

@Repository
public class RestrictedWordDAOImpl extends EntityDAOImpl<RestrictedWord, Long> implements RestrictedWordDAO {
	
	private static long nextval = 1;
	
	public RestrictedWordDAOImpl() {
		RestrictedWord word = new RestrictedWord();
		
		word.setWord("cannabis");
		persist(word);
		
		word.setWord("abuse");
		persist(word);
		
		word.setWord("crack");
		persist(word);
		
		word.setWord("damn");
		persist(word);
		
		word.setWord("drunk");
		persist(word);
		
		word.setWord("grass");
		persist(word);
	}

	@Override
	protected Long nextval() {
		return nextval++;
	}
	
	public boolean containsRestrictedWord(String username) {
		if (username != null) {
			for (RestrictedWord word : getAll()) {
				if (username.contains(word.getWord())) {
					return true;
				}
			}
		}
		return false;
	}
	
}
