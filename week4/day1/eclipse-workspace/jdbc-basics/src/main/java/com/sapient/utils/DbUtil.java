package com.sapient.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public final class DbUtil {

	private DbUtil() {
	}

	// a custom factory method to create a connection (a.k.a virtual constructor)
	public static Connection createConnection() throws SQLException, ClassNotFoundException {
		ResourceBundle rb = ResourceBundle.getBundle("jdbc-info");
		String url = rb.getString("jdbc.connection.url");
		String username = rb.getString("jdbc.connection.username");
		String password = rb.getString("jdbc.connection.password");
		String driverClassName = rb.getString("jdbc.driver-class-name");

		// load the driver class into the JVM, so that it can instatiate itself, and
		// register the same with DriverManager
		Class.forName(driverClassName);

		return DriverManager.getConnection(url, username, password);

	}
}
