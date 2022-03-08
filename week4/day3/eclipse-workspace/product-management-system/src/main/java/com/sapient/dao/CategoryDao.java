package com.sapient.dao;

import java.util.List;

import com.sapient.entity.Category;

public interface CategoryDao {

	public List<Category> findAll() throws DaoException;
}
