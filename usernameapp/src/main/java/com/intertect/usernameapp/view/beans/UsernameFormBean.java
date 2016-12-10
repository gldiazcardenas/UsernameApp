package com.intertect.usernameapp.view.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.intertect.usernameapp.dto.UsernameValidationResult;
import com.intertect.usernameapp.service.UsernameValidator;

@Component
@ManagedBean
@RequestScoped
public class UsernameFormBean {
	
	@Autowired
	private UsernameValidator usernameValidator;
	
	private String username;
	private String message;
	private boolean invalid;
	private List<String> suggestedUsernames;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public List<String> getSuggestedUsernames() {
		return suggestedUsernames;
	}
	
	public boolean isInvalid() {
		return invalid;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void checkUsername () {
		UsernameValidationResult result = usernameValidator.validate(username);
		invalid = !result.isValid();
		suggestedUsernames = result.getSuggestedUsernames();
		
		if (result.isValid()) {
			message = "The username is valid.";
		}
		else if (suggestedUsernames.isEmpty()) {
			message = "There are not suggested usernames, it might contain a restricted word.";
		}
		else {
			message = "The user is already taken, below there are some suggestions:";
		}
	}
	
	public void clear () {
		username = null;
		suggestedUsernames = null;
		message = null;
		invalid = false;
	}
	
}
