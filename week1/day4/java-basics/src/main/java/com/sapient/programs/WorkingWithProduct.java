package com.sapient.programs;

import com.sapient.entity.Product;

public class WorkingWithProduct {
    public static void main(String[] args) {
        Product p1; // we are able to use the class since it is defined as public
        p1 = new Product(); // we are able to use the constructor because it is public

        p1.setId(12);
        p1.setPrice(199.0);
        p1.setName("Logitech Mouse");

        System.out.println(p1); // trying to treat "p1" as a string here
        // println calls p1.toString() in order to get the string version p1

        // p1.printDetails();

        Product p2 = new Product();
        p2.setId(190);
        p2.setName("Apple Macbook Pro");
        p2.setPrice(190000);
        System.out.println(p2);
    }
}
