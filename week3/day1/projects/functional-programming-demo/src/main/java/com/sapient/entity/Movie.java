package com.sapient.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie implements Comparable<Movie> {
	private int id;
	private String title;
	private int runningTime;
	private int releaseYear;

	// defines the natural ordering of two movies
	@Override
	public int compareTo(Movie other) {
		return Integer.compare(this.id, other.id);
	}
}
