package com.sapient.utils;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sapient.entity.Category;
import com.sapient.entity.Product;

public final class HibernateUtil {

	private HibernateUtil() {
	}

	// singleton instance
	private static final SessionFactory factory; // represents a db

	static {
		Properties props = new Properties();

		// add all properties from hibernate.cfg.xml
		props.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		props.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/northwind");
		props.setProperty("hibernate.connection.username", "root");
		props.setProperty("hibernate.connection.password", "Welcome#123");
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("hibernate.format_sql", "true");
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		// props.setProperty("hibernate.hbm2ddl.auto", "update");

		factory = new Configuration()
				.addProperties(props)
				.addAnnotatedClass(Category.class)
				.addAnnotatedClass(Product.class)
				.buildSessionFactory();
	}

	public static Session getSession() {
		return factory.openSession(); // represents a new DB connection; needs to be closed ASAP
	}
}
