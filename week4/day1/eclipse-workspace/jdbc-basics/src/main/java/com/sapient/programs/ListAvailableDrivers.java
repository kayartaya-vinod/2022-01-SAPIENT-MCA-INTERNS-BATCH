package com.sapient.programs;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class ListAvailableDrivers {

	public static void main(String[] args) {

		// Whenever a JDBC implementation is added to the class-path, it will
		// automatically register an instance of its own Driver class. In the past, we
		// had to do it manually by calling Class.forName("driver-class-name") method
		Enumeration<Driver> drivers = DriverManager.getDrivers();

		System.out.println("Here is the list of all drivers that are currently loaded in the JVM");
		while (drivers.hasMoreElements()) {
			Driver elem = drivers.nextElement();
			System.out.println(elem.getClass().getName());
		}
	}

}
