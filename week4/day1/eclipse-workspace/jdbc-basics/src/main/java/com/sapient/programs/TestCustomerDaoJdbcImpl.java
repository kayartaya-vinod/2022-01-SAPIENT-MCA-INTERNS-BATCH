package com.sapient.programs;

import com.sapient.dao.CustomerDao;
import com.sapient.dao.CustomerDaoJdbcImpl;
import com.sapient.dao.DaoException;
import com.sapient.entity.Customer;

public class TestCustomerDaoJdbcImpl {

	public static void main(String[] args) throws DaoException {
		
		CustomerDao dao = new CustomerDaoJdbcImpl(); // replace this with factory method
		
		Customer cust = dao.findById(12);
		System.out.println(cust);
		
		System.out.println("-".repeat(50));
		
		dao.findByState("Porto")
			.forEach(System.out::println);
		
		
	}
}
