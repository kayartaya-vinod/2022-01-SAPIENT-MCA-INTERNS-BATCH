package com.sapient.programs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CollectionsUtilClassDemo {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("Vinod");
        list.add(0, "Shyam");
        list.add("John");
        list.add("Vinay");
        list.add("Shyam");
        list.add("Suresh");
        list.add(6, "Kumar");

        print("Origin list", list);
        Collections.reverse(list);
        print("After reversing", list);
        Collections.shuffle(list);
        print("After shuffling", list);
        Collections.sort(list);
        print("After sorting", list);

        // thread-safe list
        List<String> list1 = Collections.synchronizedList(list);
        System.out.println("list1 is of type " + list1.getClass().getName());

        // this an immutable list
        List<String> list2 = Collections.unmodifiableList(list);
        print("immutable list", list2);
        // list2.add("Shubha"); // error
        // list2.remove("Vinod");


    }

    static void print(String msg, Collection<?> coll) {
        System.out.println(msg);
        for (Object obj : coll) {
            System.out.println(obj);
        }
        System.out.println();
    }

}
