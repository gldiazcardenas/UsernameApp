package com.intertect.usernameapp.view.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.intertect.usernameapp.model.User;
import com.intertect.usernameapp.service.UserService;

@Component
@ManagedBean
@SessionScoped
public class UserFormBean {
	
	@Autowired
	private UserService userService;
	
	private final List<User> users = new ArrayList<User>();
	
	@PostConstruct
	private void init () {
		users.addAll(userService.getAll());
	}
	
	public List<User> getUsers() {
		return users;
	}
	
}
