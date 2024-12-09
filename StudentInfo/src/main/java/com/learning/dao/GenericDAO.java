package com.learning.dao;

import java.util.List;

public interface GenericDAO<E> {

	public List<E> listAll();
}
