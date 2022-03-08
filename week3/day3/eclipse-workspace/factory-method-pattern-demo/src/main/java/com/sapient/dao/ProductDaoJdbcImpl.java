package com.sapient.dao;

import com.sapient.entity.Product;

public class ProductDaoJdbcImpl implements ProductDao {

	@Override
	public Product findById(int id) {
		System.out.println("Returning product from MySQL using JDBC api");
		return null;
	}

}
