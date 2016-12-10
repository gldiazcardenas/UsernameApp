package com.intertect.usernameapp.view.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.intertect.usernameapp.model.RestrictedWord;
import com.intertect.usernameapp.service.RestrictedWordService;

@Component
@ManagedBean
@SessionScoped
public class RestrictedWordFormBean {
	
	@Autowired
	private RestrictedWordService restrictedWordService;
	
	private final List<RestrictedWord> restrictedWords = new ArrayList<RestrictedWord>();
	private String word;
	
	@PostConstruct
	private void init () {
		restrictedWords.addAll(restrictedWordService.getAll());
	}
	
	public List<RestrictedWord> getRestrictedWords() {
		return restrictedWords;
	}
	
	public String getWord() {
		return word;
	}
	
	public void setWord(String word) {
		this.word = word;
	}
	
	public void add () {
		RestrictedWord restrictedWord = new RestrictedWord();
		restrictedWord.setWord(word);
		restrictedWordService.persist(restrictedWord);
		restrictedWords.add(restrictedWord);
		word = null;
	}
	
	public void remove (RestrictedWord restrictedWord) {
		restrictedWordService.delete(restrictedWord.getId());
		restrictedWords.remove(restrictedWord);
	}

}
