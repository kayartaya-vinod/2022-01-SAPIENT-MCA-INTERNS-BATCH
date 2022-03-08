package com.sapient.dao;

import com.sapient.entity.Product;

public class ProductDaoHibernateImpl implements ProductDao {

	@Override
	public Product findById(int id) {
		System.out.println("Returning product from MySQL using Hibernate api");
		return null;
	}

}
