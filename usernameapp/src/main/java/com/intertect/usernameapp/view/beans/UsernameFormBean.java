package com.intertect.usernameapp.view.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.stereotype.Component;

@Component
@ManagedBean(name = "usernameFormBean")
@RequestScoped
public class UsernameFormBean {
	
	private String username;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

}
