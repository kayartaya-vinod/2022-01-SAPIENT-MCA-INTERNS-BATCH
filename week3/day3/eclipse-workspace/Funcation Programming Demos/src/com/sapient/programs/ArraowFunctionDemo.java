package com.sapient.programs;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@FunctionalInterface
interface Factorial {
	long factorial(int num);
}

public class ArraowFunctionDemo {

	static void printInfo(Runnable r) {
		System.out.println("r is an instance of " + r.getClass().getName());
	}

	static Runnable getEmptyRunnable() {
		return () -> {
		};
	}

	public static void main(String[] args) {

		Runnable r1 = () -> {
		};

		final int num;
		num = 123;

		printInfo(r1);

		printInfo(() -> {
		});

		List<String> names = Arrays.asList("Vinod", "Shyam", "Ramesh", "Suresh");
		Collections.sort(names, (x, y) -> y.compareTo(x));

	}

}
