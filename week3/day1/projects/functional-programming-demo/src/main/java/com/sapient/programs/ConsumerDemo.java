package com.sapient.programs;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {

	public static void main(String[] args) {

		// A Consumer object represents a function which receives exactly one argument
		// and returns void.

		Consumer<Integer> printSquare = (num) -> System.out.printf("Square of %d is %d\n", num, num * num);
		Consumer<Integer> printCube = (n) -> System.out.printf("Cube of %d is %d\n", n, n * n * n);
		Consumer<Integer> printEvenOdd = (n) -> System.out.printf("%d is %s\n", n, n % 2 == 0 ? "even" : "odd");
		// this is a useless function; just for demonstration :-)
		Consumer<Integer> ignoreAndPrintLine = (n) -> System.out.println();

		List<Integer> nums = Arrays.asList(92, 28, 48, 35, 18, 19, 46, 56);

		nums.forEach(printSquare.andThen(printCube).andThen(printEvenOdd).andThen(ignoreAndPrintLine));

		nums.forEach(n -> System.out.println("**" + n + "**"));

	}

}
