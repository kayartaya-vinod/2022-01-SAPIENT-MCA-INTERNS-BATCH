package com.sapient.programs;

import com.sapient.entity.Book;

public class ClassesAndObjectsDemo {

    public static void main(String[] args) {
        Book b1; // stack variables are not initialized by default
        b1 = new Book(); // create and assign the object's reference

        System.out.println("b1 currently has " + b1);
        System.out.println("Book id is " + b1.id);
        System.out.println("Book title is " + b1.title);
        System.out.println("Book author is " + b1.author);
        System.out.println("Book price is " + b1.price);

        b1.id = 123;
        b1.title = "Programming in Java"; // new String("Programming in Java");
        b1.price = -900;
        System.out.println();
        System.out.println("Book id is " + b1.id);
        System.out.println("Book title is " + b1.title);
        System.out.println("Book author is " + b1.author);
        System.out.println("Book price is " + b1.price);

        // java.lang.Double is a wrapper class for the primitive "double"
        System.out.println("Max value in a double variable is " + Double.MAX_VALUE);
        System.out.println("Min value in a double variable is " + Double.MIN_VALUE);

    }
}
