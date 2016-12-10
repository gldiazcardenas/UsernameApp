package com.intertect.usernameapp.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.intertect.usernameapp.dao.EntityDAO;
import com.intertect.usernameapp.model.Entity;

public abstract class EntityDAOImpl <E extends Entity<PK>, PK extends Serializable> implements EntityDAO<E, PK> {
	
	protected final Map<PK, E> entities = new HashMap<PK, E>();
	
	protected abstract PK nextval();
	
	public void persist(E entity) {
		if (entity != null) {
			entity.setId(nextval());
			entities.put(entity.getId(), entity);
		}
	}
	
	public void update(E entity) {
		if (entity != null) {
			entities.remove(entity.getId());
			entities.put(entity.getId(), entity);
		}
	}
	
	public void delete(PK id) {
		entities.remove(id);
	}
	
	public E getById(PK id) {
		return entities.get(id);
	}
	
	public Collection<E> getAll() {
		return entities.values();
	}
	
}
