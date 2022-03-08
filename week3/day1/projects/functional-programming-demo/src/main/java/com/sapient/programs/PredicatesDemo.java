package com.sapient.programs;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicatesDemo {

	public static void main(String[] args) {

		Predicate<Integer> isEven = (n) -> n % 2 == 0;
		Predicate<Integer> isLessThanHundred = (n) -> n < 100;
		Predicate<Integer> isDivisibleByFive = (n) -> n % 5 == 0;

		Consumer<Integer> printDetails = (n)->{
			
				
			System.out.println(
					isLessThanHundred
					.and(isEven)
					.and(isDivisibleByFive)
					.test(n) ?
							n + " is your number" : 
							n + " is not the number you are looking for"
						
					);
		};
		
		
		List<Integer> nums = Arrays.asList(92, 50, 48, 35, 118, 19, 46, 56, 252, 70, 74);

		nums.forEach(printDetails);
		
	}

}
