package com.sapient.dao;

import java.util.List;

import com.sapient.entity.Product;

public interface ProductDao {

	// CRUD operations
	public Product create(Product product) throws DaoException;

	public Product findById(Integer id) throws DaoException;

	public Product update(Product product) throws DaoException;

	// Query operations
	public List<Product> findAll() throws DaoException;

	public List<Product> findByPriceRange(Double min, Double max) throws DaoException;

}
