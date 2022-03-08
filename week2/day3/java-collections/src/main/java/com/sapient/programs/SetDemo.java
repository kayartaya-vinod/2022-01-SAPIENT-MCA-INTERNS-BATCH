package com.sapient.programs;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import com.sapient.entity.Book;

public class SetDemo {

    public static void main(String[] args) {

        Set<Integer> nums = new HashSet<>();
        nums.add(100);
        nums.add(123);
        nums.add(100);
        nums.add(30);
        nums.add(45);
        nums.add(2);
        System.out.println(nums);

        Set<String> names = new TreeSet<>();
        names.add("Vinod");
        names.add("Vinod");
        names.add("Anil");
        names.add("Avinash");
        names.add("Bnil");
        System.out.println(names);

        Set<Book> books = new HashSet<>();
        Book b;

        b = new Book(11, "Let Us C", 299.0);
        books.add(b);
        System.out.println("b.hashCode() is " + b.hashCode());
        b = new Book(11, "Let Us C", 299.0);
        books.add(b);
        System.out.println("b.hashCode() is " + b.hashCode());
        b = new Book(11, "Let Us C", 299.0);
        books.add(b);
        System.out.println("b.hashCode() is " + b.hashCode());

        Iterator<Book> it = books.iterator();
        while (it.hasNext()) {
            Book b1 = it.next();
            System.out.println(b1);
        }

        Book book1 = new Book(10, "Let us Java", 499.0);
        Book book2 = new Book(10, "Let us Java", 499.0);
        Book book3 = new Book(10, "Let us Java", 491.0);

        System.out.println("book1.equals(book2) is " + book1.equals(book2));
        System.out.println("book1.equals(book3) is " + book1.equals(book3));
    }
}
