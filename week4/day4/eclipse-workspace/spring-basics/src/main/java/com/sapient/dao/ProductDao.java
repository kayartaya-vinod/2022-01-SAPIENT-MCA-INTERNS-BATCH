package com.sapient.dao;

import java.util.List;

import com.sapient.entity.Product;

public interface ProductDao {

	// CRUD operations (to be done)
	public default Product create(Product product) throws DaoException {
		throw new DaoException("This method currently not available");
	}

	public default Product update(Product product) throws DaoException {
		throw new DaoException("This method currently not available");
	}

	public default Product findById(Integer id) throws DaoException {
		throw new DaoException("This method currently not available");
	}

	// Query operations (many to be added)
	public long count() throws DaoException;

	public default List<Product> findAll() throws DaoException {
		throw new DaoException("This method currently not available");
	}

	public default List<Product> findByPriceRange(Double min, Double max) throws DaoException {
		throw new DaoException("This method currently not available");
	}

}
