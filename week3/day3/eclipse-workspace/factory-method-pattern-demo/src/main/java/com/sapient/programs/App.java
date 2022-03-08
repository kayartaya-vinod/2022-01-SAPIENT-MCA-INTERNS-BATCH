package com.sapient.programs;

import com.sapient.dao.DaoFactory;
import com.sapient.dao.ProductDao;
import com.sapient.entity.Product;

public class App {

	public static void main(String[] args) {

		// dependency
		ProductDao dao;
		
		// tight coupling
		// dao = new ProductDaoHibernateImpl();
		
		// loose coupling using virtual constructor
		dao = DaoFactory.getProductDao();
		
		// use the dependency
		Product p = dao.findById(12);
	}

}
