package com.sapient.programs;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sapient.entity.Customer;
import com.sapient.utils.HibernateUtil;

public class AddNewCustomer {

	public static void main(String[] args) {

		Customer c1 = new Customer();
		c1.setName("Vinod Kumar");
		c1.setEmail("vinod@vinod.co");
		c1.setPhone("9731424784");
		c1.setCity("Bangalore");
		c1.setState("Karnataka");
		c1.setId(1001); // can we autogenerate this???

		try (Session session = HibernateUtil.getSession();) {

			Transaction tx = session.beginTransaction();
			try {
				session.persist(c1); // adds a metadata to c1 as "new"
				tx.commit(); // sql statements are sent to the db for execution
				System.out.println("Data saved successfully!");
			} catch (Exception e) {
				e.printStackTrace();
				tx.rollback();
			}

		}

	}
}
