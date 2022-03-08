package com.sapient.programs;

import com.sapient.entity.Movie;

public class MovieDetails {
    public static void main(String[] args) {

        Movie m1 = new Movie();
        Movie m2 = new Movie("12ef83", "Mask", "Comedy, action", 172);

        System.out.println(m1);
        System.out.println(m2);
    }

}
