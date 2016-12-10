package com.intertect.usernameapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intertect.usernameapp.dao.UserDAO;
import com.intertect.usernameapp.model.User;
import com.intertect.usernameapp.service.UserService;

@Service
public class UserServiceImpl extends EntityServiceImpl<User, Long> implements UserService {
	
	@Autowired
	private UserDAO dao;
	
	@Override
	public boolean isTakenUsername(String username) {
		return dao.isTakenUsername(username);
	}

	@Override
	protected UserDAO getDAO() {
		return dao;
	}

}
