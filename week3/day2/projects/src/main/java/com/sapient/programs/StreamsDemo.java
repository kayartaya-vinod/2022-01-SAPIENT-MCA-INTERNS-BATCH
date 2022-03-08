package com.sapient.programs;

import java.util.Arrays;
import java.util.List;

public class StreamsDemo {

	public static void main(String[] args) {

		List<String> names = Arrays.asList("Vinod Kumar Kayartaya", "Shyam Sundar KC", "Murali", "Venugopala Rao", "Kishore Kumar", "Arun", "Rahul", "Pranav",
				"Ashish");

		names.stream()
				.map(name -> name.substring(0, 3))
				.map(String::toUpperCase)
				.forEach(name -> System.out.println(name));
		
		
		System.out.println("-------------");
		
		List<Integer> numbers = Arrays.asList(190, 29, 148, 57, 282, 3383, 44, 38, 19, 9);
		
		numbers.stream()
			.filter( num -> num>=100 ) // Eliminates numbers < 100
			.filter( num -> num%2==0 ) // Eliminates odd numbers
			.peek(System.out::println) // cannot mutate; even if you return a different value, it will be ignored
			.map(num -> new Object[] {num, Math.sqrt(num)}) // converts a number into an array of 2 elements (num, sqrt(num)
			.map(Arrays::toString) // converts an array into a string
			.forEach(System.out::println); // collects and prints on console
		
		
		System.out.println("-------------");
		numbers.stream()
			.sorted()
			.forEach(System.out::println);
		
		System.out.println("-------------");
		numbers.stream()
			.sorted(StreamsDemo::swapAndCompare)
			.forEach(System.out::println);
		
	}
	
	static int swapAndCompare(int a, int b) {
		return Integer.compare(b, a);
	}

}
