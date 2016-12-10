package com.intertect.usernameapp.model;

import java.io.Serializable;

public abstract class Entity<PK extends Serializable> {
	
	public abstract PK getId();
	
	public abstract void setId (PK id);

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		
		Entity<?> other = (Entity<?>) obj;
		
		if (getId() == null) {
			if (other.getId() != null) {
				return false;
			}
		} else if (!getId().equals(other.getId())) {
			return false;
		}
		
		return true;
	}
	
}
