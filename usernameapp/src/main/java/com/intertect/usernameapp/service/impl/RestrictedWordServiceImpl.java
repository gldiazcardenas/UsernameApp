package com.intertect.usernameapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intertect.usernameapp.dao.RestrictedWordDAO;
import com.intertect.usernameapp.model.RestrictedWord;
import com.intertect.usernameapp.service.RestrictedWordService;

@Service
public class RestrictedWordServiceImpl extends EntityServiceImpl<RestrictedWord, Long> implements RestrictedWordService {
	
	@Autowired
	private RestrictedWordDAO dao;

	@Override
	public boolean containsRestrictedWord(String username) {
		return dao.containsRestrictedWord(username);
	}

	@Override
	protected RestrictedWordDAO getDAO() {
		return dao;
	}

}
