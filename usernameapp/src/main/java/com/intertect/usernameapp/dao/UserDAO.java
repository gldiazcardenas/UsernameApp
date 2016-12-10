package com.intertect.usernameapp.dao;

import com.intertect.usernameapp.model.User;

public interface UserDAO extends EntityDAO<User, Long> {
	
	public boolean isTakenUsername (String username);

}
