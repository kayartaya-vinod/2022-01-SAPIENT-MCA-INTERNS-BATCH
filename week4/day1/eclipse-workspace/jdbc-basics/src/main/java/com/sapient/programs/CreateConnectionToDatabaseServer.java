package com.sapient.programs;

import java.sql.Connection;
import java.sql.DriverManager;

public class CreateConnectionToDatabaseServer {

	public static void main(String[] args) throws Exception {

		// discriminator for the factory method
		// http://vinod.co:80/blog/whoami
		String url = "jdbc:h2:tcp://localhost/~/trainingdb";
		String username = "root";
		String password = "Welcome#123";

		Connection conn = DriverManager.getConnection(url, username, password);
		System.out.println("Got a connection of type: " + conn.getClass().getName());
	}

}
