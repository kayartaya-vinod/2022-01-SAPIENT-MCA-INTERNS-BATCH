package com.sapient.entity;

public class Util {

    public static <T> void displayInfo(T val) {
        System.out.printf("Got a value %s of type %s\n", val, val.getClass().getName());
    }
}
