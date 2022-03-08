package com.sapient.programs;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CustomSortingDemo {

	public static void main(String[] args) {

		List<String> names = Arrays.asList("Vinod", "Shyam", "Arun", "Naveen", "Nived", "Suresh");
		System.out.println("names is of type: " + names.getClass().getName());

		System.out.println("names is: " + names);
		Collections.sort(names);
		System.out.println("After sorting, names is: " + names);

		// cmp1 is an object of anonymous class that implements Comparator interface,
		// and has a method called "compare", which can compare 2 string objects,
		// and returns negative, zero or positive number.
		Comparator<String> cmp1 = new Comparator<>() {
			@Override
			public int compare(String s1, String s2) {
				return s2.compareTo(s1);
			}
		};

		// we are passing the logic to compare 2 strings as an object cmp1
		Collections.sort(names, cmp1);
		System.out.println("After sorting, names is: " + names);

		// we are now passing an anonymous object as parameter
		Collections.sort(names, new Comparator<>() {
			@Override
			public int compare(String s1, String s2) {
				return s2.compareTo(s1);
			}
		});
		System.out.println("After sorting, names is: " + names);

		Collections.sort(names, (s1, s2) -> s2.compareTo(s1));
		System.out.println("After sorting, names is: " + names);

	}
}
