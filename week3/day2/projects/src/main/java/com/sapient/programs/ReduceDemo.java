package com.sapient.programs;

import java.util.Arrays;
import java.util.List;

public class ReduceDemo {

	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(190, 29, 148, 57, 282, 3383, 44, 38, 19, 9);
		
		// numbers.size(); // length of the list
		
		long count = numbers.stream()
			.filter(n -> n%2==0)
			.peek(System.out::println)
			.count();
		
		System.out.printf("There are %d even numbers\n", count);
		
	
		int total = numbers.stream()
			.filter(n -> n%2 == 0)
			.reduce(0, (a, b)->a+b);
		
		System.out.println("Sum of all even numbers = " + total);
		
		List<String> words = Arrays.asList("my", "name", "is", "Vinod");
		
		String sentence = words.stream()
			.reduce("The concatenated string is: ", (w1, w2)-> w1 + " " + w2);
		
		System.out.println(sentence);
	}
	
}
