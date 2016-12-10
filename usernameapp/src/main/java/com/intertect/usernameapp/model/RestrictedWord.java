package com.intertect.usernameapp.model;

import java.io.Serializable;

public class RestrictedWord extends Entity<Long> implements Serializable {

	private static final long serialVersionUID = -8934151944303189829L;
	
	private Long id;
	
	private String word;
	
	@Override
	public Long getId() {
		return id;
	}
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getWord() {
		return word;
	}
	
	public void setWord(String word) {
		this.word = word;
	}

}
