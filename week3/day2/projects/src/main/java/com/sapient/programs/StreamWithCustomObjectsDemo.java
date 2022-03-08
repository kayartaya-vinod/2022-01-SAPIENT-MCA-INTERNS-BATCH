package com.sapient.programs;

import java.util.Arrays;
import java.util.List;

import com.sapient.entity.Book;

public class StreamWithCustomObjectsDemo {

	public static void main(String[] args) {

		List<Book> books = Arrays.asList(
				new Book(1, "Let us C", 299),
				new Book(2, "Let us Java", 499),
				new Book(4, "Let us C++", 345),
				new Book(6, "Let us C#", 1900),
				new Book(3, "Let us Python", 199),
				new Book(5, "Understanding docker", 390),
				new Book(9, "K8s made easy", 2390)
			);
		
		// books where price is >= 500
		books.stream()
			.filter( b -> b.getPrice() >= 500)
			.forEach(System.out::println);
		
		System.out.println("------------------------");
		
		// book titles in upper case where price is >= 400
		books.stream()
			.filter( b -> b.getPrice() >= 400)
			.map( b -> b.getTitle())
			.map(String::toUpperCase)
			.forEach(System.out::println);
		
		System.out.println("------------------------");
		
		// book titles and prices in descending order of their prices
		books.stream()
			.sorted((b1, b2)-> Double.compare(b2.getPrice(), b1.getPrice()))
			.map(b->new Object[] {b.getTitle(), b.getPrice()})
			.map(Arrays::toString)
			.forEach(System.out::println);
	
		// get the total of all book prices
		Double total = books.stream()
			.map( b -> b.getPrice() )
			.reduce(0.0, (pr1, pr2) -> pr1+pr2);
		// 0.0, 299 --> 299
		// 299, 499 --> 708
		// 708, 345 --> 1053
		// 1053, 1900 --> ...
		// ...
		
		System.out.println("Total price of all the books is " + total);
	}

}
