package com.sapient.dao;

import java.util.ResourceBundle;

public final class DaoFactory {
	private static String productDaoImplClassName, categoryDaoImplClassName;

	private DaoFactory() {
	}
	
	static {
		ResourceBundle rb = ResourceBundle.getBundle("dao"); // dao.properties in src/main/resources
		productDaoImplClassName = rb.getString("product-dao.impl");
		categoryDaoImplClassName = rb.getString("category-dao.impl");
	}
	
	public static ProductDao getProductDao() {
		try {
			return (ProductDao) Class.forName(productDaoImplClassName) // load the class to JVM
					.getDeclaredConstructor()	// get the default constructor
					.newInstance();				// instantiate
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static CategoryDao getCategoryDao() {
		try {
			return (CategoryDao) Class.forName(categoryDaoImplClassName) // load the class to JVM
					.getDeclaredConstructor()	// get the default constructor
					.newInstance();				// instantiate
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
