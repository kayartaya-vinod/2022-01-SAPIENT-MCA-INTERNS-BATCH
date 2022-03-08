package com.sapient.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.sapient.entity.Book;

public class CollectorsDemo {
	
	static List<String> getTitles1(List<Book> books) {
		List<String> titles = new ArrayList<>();
		
		books.stream()
				.map(b -> b.getTitle())
				.forEach(titles::add);
		
		return titles;
	}
	
	static List<String> getTitles(List<Book> books) {
		return books.stream()
				.map(b -> b.getTitle())
				.collect(Collectors.toList());
	}

	public static void main(String[] args) {
		List<Book> books = Arrays.asList(
				new Book(1, "Let us C", 299),
				new Book(2, "Let us Java", 499),
				new Book(4, "Let us C++", 345),
				new Book(6, "Let us C#", 1900),
				new Book(3, "Let us Python", 499),
				new Book(5, "Understanding docker", 499),
				new Book(9, "K8s made easy", 2390)
			);
		
		// convert the list of books into list titles
		List<String> titles = getTitles(books);
		
		System.out.println(titles);
		
		// get a collection of distinct book prices
		List<Double> prices = books.stream()
			.map(b->b.getPrice())
			.distinct()
			.collect(Collectors.toList());
		
		System.out.println(prices);
		
		Map<Integer, String> map = books.stream()
			.collect(Collectors.toMap(Book::getId, Book::getTitle));
		
		for(Entry<Integer, String> entry: map.entrySet()) {
			System.out.println(entry.getKey() + " --> " + entry.getValue());
		}
	}

}
