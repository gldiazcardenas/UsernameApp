package com.intertect.usernameapp.dao.impl;

import org.springframework.stereotype.Repository;

import com.intertect.usernameapp.dao.UserDAO;
import com.intertect.usernameapp.model.User;

@Repository
public class UserDAOImpl extends EntityDAOImpl<User, Long> implements UserDAO {
	
	private static long nextval = 1;
	
	public UserDAOImpl() {
		User user;
		
		user = new User();
		user.setUsername("Gabriel");
		persist(user);
		
		user = new User();
		user.setUsername("Leonardo");
		persist(user);
		
		user = new User();
		user.setUsername("gldiazcardenas");
		persist(user);
		
		user = new User();
		user.setUsername("intertect");
		persist(user);
	}
	
	public boolean isTakenUsername (String username) {
		for (User user : getAll()) {
			if (user.getUsername().equals(username)) {
				return true;
			}
		}
		return false;
	}

	@Override
	protected Long nextval() {
		return nextval++;
	}

}
