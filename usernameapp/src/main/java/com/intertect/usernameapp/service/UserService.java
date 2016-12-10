package com.intertect.usernameapp.service;

import com.intertect.usernameapp.model.User;

public interface UserService extends EntityService<User, Long> {
	
	public boolean isTakenUsername (String username);

}
