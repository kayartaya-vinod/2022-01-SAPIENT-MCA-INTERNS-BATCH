package com.sapient.app;

import java.util.InputMismatchException;

import com.sapient.service.CalculatorService;

public class MathsApp {

	// dependency (interface, and an object of some implementing class is injected
	// using either constructor or setter)
	private CalculatorService service;

	// default / no-arg constructor (for better practice)
	public MathsApp() {
	}

	// overloaded constructor for dependency injection
	public MathsApp(CalculatorService service) {
		super();
		this.service = service;
	}

	// a setter for dependency injection
	public void setService(CalculatorService service) {
		this.service = service;
	}

	// operations that make use of the dependency
	public double addNumbers(String string) {
		// string --> 10, 20, 30, 40, 50
		String[] arr = string.split(",");
		double num;
		double total = 0;
		for (int i = 0; i < arr.length; i++) {
			num = Double.parseDouble(arr[i].strip());
			total = service.add(total, num);
		}
		return total;
	}

	public double divide(String string) {
		String[] arr = string.split(",");
		if (arr.length != 2) {
			throw new InputMismatchException("Expected 2 numbers separated by comma");
		}
		int num = Integer.parseInt(arr[0].strip());
		int den = Integer.parseInt(arr[1].strip());
		return service.divide(num, den);
	}

	public double subtract(String string) {
		String[] arr = string.split(",");
		int num1 = Integer.parseInt(arr[0].strip());
		int num2 = Integer.parseInt(arr[1].strip());
		return service.subtract(num1, num2);
	}

	public double multiply(String string) {
		String[] arr = string.split(",");
		int num1 = Integer.parseInt(arr[0].strip());
		int num2 = Integer.parseInt(arr[1].strip());
		return service.multiply(num1, num2);
	}

}
