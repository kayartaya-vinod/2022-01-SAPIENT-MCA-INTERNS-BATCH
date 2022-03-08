package com.sapient.entity;

public class Product {
    // these variables can not be accessed by any other class; even if it is in the
    // same package
    private int id;
    private String name;
    private double price;

    // there will be a public no-argument constructor by default
    // provided by the compiler - public com.sapient.entity.Product();
    // Hence, it is also known as "default constructor"

    public void setId(int id) {
        if (id < 0) {
            throw new RuntimeException("negative id not allowed");
        }
        this.id = id;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new RuntimeException("Price must be > zero");
        }
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printDetails() {
        System.out.println("ID     : " + id);
        System.out.println("Name   : " + name);
        System.out.println("Price  : " + price);
        System.out.println();
    }

    // overriding of inherited superclass method
    public String toString() {
        return "ID = " + id + ", Name = " + name + ", Price = " + price;
    }
}
