package com.sapient.programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sapient.entity.Customer;

public class GetCustomerData {

	public static void main(String[] args) {

		// 1. Create a Hibernate Configuration object
		Configuration cfg = new Configuration();

		// 2. Read from hibernate.cfg.xml (in the classpath)
		cfg.configure();

		// 3. add all entity classes to manage
		cfg.addAnnotatedClass(Customer.class);

		// 4.. build a session factory object
		SessionFactory factory = cfg.buildSessionFactory(); // represents a db

		// 5. get a session object (represents a db connection)
		try (Session session = factory.openSession()) {

			Customer cust = session.get(Customer.class, 1001); // a db visit is made
			System.out.println(cust);

		} // session is closed here

	}

}
