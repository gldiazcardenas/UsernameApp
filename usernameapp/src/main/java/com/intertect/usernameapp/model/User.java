package com.intertect.usernameapp.model;

import java.io.Serializable;

public class User extends Entity<Long> implements Serializable {

	private static final long serialVersionUID = -1431860659798821980L;
	
	private Long id;
	private String username;
	
	@Override
	public Long getId() {
		return id;
	}
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
}
