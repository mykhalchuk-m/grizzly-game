package com.game.grizzly.app.ds.dao;

import java.io.Serializable;

public interface GenericDao<T, PK extends Serializable> {
	PK create(T t);

	T read(PK id);

	void update(T t);

	void delete(T t);
}
