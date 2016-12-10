package com.intertect.usernameapp.service.impl;

import java.io.Serializable;
import java.util.Collection;

import com.intertect.usernameapp.dao.EntityDAO;
import com.intertect.usernameapp.model.Entity;
import com.intertect.usernameapp.service.EntityService;

public abstract class EntityServiceImpl <E extends Entity<PK>, PK extends Serializable> implements EntityService<E, PK> {

	@Override
	public void persist(E entity) {
		getDAO().persist(entity);
	}

	@Override
	public void update(E entity) {
		getDAO().update(entity);
	}

	@Override
	public void delete(PK id) {
		getDAO().delete(id);
	}

	@Override
	public E getById(PK id) {
		return getDAO().getById(id);
	}
	
	@Override
	public Collection<E> getAll() {
		return getDAO().getAll();
	}
	
	protected abstract EntityDAO<E, PK> getDAO();

}
