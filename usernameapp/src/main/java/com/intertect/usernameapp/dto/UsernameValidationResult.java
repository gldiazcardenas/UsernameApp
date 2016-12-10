package com.intertect.usernameapp.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UsernameValidationResult implements Serializable {

	private static final long serialVersionUID = -9024273658816435432L;
	
	private boolean valid;
	private List<String> suggestedUsernames;
	
	public UsernameValidationResult() {
		this(false);
	}
	
	public UsernameValidationResult(boolean valid) {
		this.valid = valid;
		this.suggestedUsernames = new ArrayList<String>();
	}
	
	public boolean isValid() {
		return valid;
	}
	
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
	public void addSuggestedUsername (String username) {
		suggestedUsernames.add(username);
	}
	
	public int getSuggestedUsernamesSize () {
		return suggestedUsernames.size();
	}
	
	public List<String> getSuggestedUsernames() {
		return suggestedUsernames;
	}
	
	public void setSuggestedUsernames(List<String> suggestedUsernames) {
		this.suggestedUsernames = suggestedUsernames;
	}

}
