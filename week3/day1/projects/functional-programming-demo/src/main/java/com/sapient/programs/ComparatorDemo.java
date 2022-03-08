package com.sapient.programs;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.sapient.entity.Movie;

public class ComparatorDemo {

	public static void main(String[] args) {

		List<Movie> movies = Arrays.asList(new Movie(1292, "Mask", 120, 1994),
				new Movie(7812, "Baby's day out", 135, 1996), new Movie(7622, "No time to die", 150, 2021),
				new Movie(5678, "Avengers", 170, 2012), new Movie(9878, "Matrix resurrection", 145, 2022));

		movies.forEach(System.out::println);
		System.out.println();

		Collections.sort(movies); // uses natural ordering of Movies objects; using Comparable.compare
		movies.forEach(System.out::println);
		System.out.println();
		
		// sort by titles
		Collections.sort(movies, (m1, m2) -> m1.getTitle().compareTo(m2.getTitle()));
		movies.forEach(System.out::println);
		System.out.println();
		
		// sort by year of release
		Collections.sort(movies, (m1, m2) -> Integer.compare(m1.getReleaseYear(), m2.getReleaseYear()));
		movies.forEach(System.out::println);
		System.out.println();
		
		

	}

	static void printMovies(List<Movie> movies) {
		// method 1 - use iterator
		/*
		 * Iterator<Movie> it = movies.iterator(); while(it.hasNext()) {
		 * System.out.println(it.next()); }
		 */

		// method 2 - use a for loop
		/*
		 * for(int i=0, j=movies.size(); i<j; i++) { System.out.println(movies.get(i));
		 * }
		 */

		// method 3 - use a enhanced for loop (java 5)
		/*
		 * for(Movie m: movies) { System.out.println(m); }
		 */

		// method 4 - use the "forEach" method in the Iterable interface (super type for
		// List) (java 8)
		// movies.forEach(m -> System.out.println(m));
		movies.forEach(System.out::println); // the forEach method takes one movie from the movies collection,
		// and passes the same directly to the System.out.println as argument.

	}

}
