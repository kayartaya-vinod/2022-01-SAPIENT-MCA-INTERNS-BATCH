package com.sapient.programs;

@FunctionalInterface
interface Test1 {
	void sayHello(String name);
}

@FunctionalInterface
interface Test2 {
	void welcome(String name);
}

public class InvalidUsageDemo {

	static void greet(Test1 t, String name) {
		t.sayHello(name);
	}

	static void greet(Test2 t, String name) {
		t.welcome(name);
	}

	public static void main(String[] args) {

		Test1 t1 = name -> System.out.println("Hello, " + name);
		Test2 t2 = name -> System.out.println("Welcome, " + name);
		
		greet(t1, "Vinod");
		greet(t2, "Vinod");
	}
}
