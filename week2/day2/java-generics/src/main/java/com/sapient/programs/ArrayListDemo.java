package com.sapient.programs;

import java.util.ArrayList;
import java.util.Date;

public final class ArrayListDemo {

    public static void main(String[] args) {

        ArrayList list = new ArrayList();
        list.add("Vinod");
        list.add("Kumar");
        list.add(1234);
        list.add(new Date());

        System.out.println(list);

        ArrayList<String> names = new ArrayList<>();
        names.add("Vinod");
        names.add("Kumar");
        // names.add(1234);
        // names.add(new Date());

        System.out.println(names);

        ArrayList<Integer> nums = new ArrayList<>();
        // nums.add("ten");
        nums.add(123);
    }
}
