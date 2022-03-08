package com.sapient.dao;

import com.sapient.entity.Product;

public class ProductDaoCsvImpl implements ProductDao {

	@Override
	public Product findById(int id) {
		System.out.println("Returning product from the CSV file");
		return null;
	}

}
