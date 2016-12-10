package com.intertect.usernameapp.service.impl;

import java.io.Serializable;

import com.intertect.usernameapp.dao.EntityDAO;
import com.intertect.usernameapp.model.Entity;
import com.intertect.usernameapp.service.EntityService;

public abstract class EntityServiceImpl <E extends Entity<PK>, PK extends Serializable> implements EntityService<E, PK> {

	public void persist(E entity) {
		getDAO().persist(entity);
	}

	public void update(E entity) {
		getDAO().update(entity);
	}

	public void delete(PK id) {
		getDAO().delete(id);
	}

	public E getById(PK id) {
		return getDAO().getById(id);
	}
	
	protected abstract EntityDAO<E, PK> getDAO();

}
