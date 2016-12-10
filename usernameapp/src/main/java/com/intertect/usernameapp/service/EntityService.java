package com.intertect.usernameapp.service;

import java.io.Serializable;

import com.intertect.usernameapp.model.Entity;

public interface EntityService <E extends Entity<PK>, PK extends Serializable> {
	
	public void persist (E entity);
	
	public void update (E entity);
	
	public void delete (PK id);
	
	public E getById (PK id);

}
