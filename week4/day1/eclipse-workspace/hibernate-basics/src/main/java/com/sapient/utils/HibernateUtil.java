package com.sapient.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sapient.entity.Customer;

public final class HibernateUtil {

	private static final SessionFactory factory;

	static {
		factory = new Configuration()
				.configure()
				.addAnnotatedClass(Customer.class)
				.buildSessionFactory();
	}

	private HibernateUtil() {
	}

	public static Session getSession() {
		return factory.openSession();
	}
}
