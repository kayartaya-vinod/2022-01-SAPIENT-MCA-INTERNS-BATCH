package com.sapient.programs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListDemo {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("Vinod");
        list.add(0, "Shyam");
        list.add("John");
        list.add("Vinod");
        list.add("Shyam");
        list.add("Suresh");
        list.add(6, "Kumar");
        list.add(6, "Kumar");
        list.add(6, "Kumar");
        list.add(6, "Kumar");

        System.out.println("list contains " + list);

        list.remove("Vinod");
        System.out.println("list contains " + list);

        list.remove("Jane"); // noop
        System.out.println("list contains " + list);

        list.remove(3);
        System.out.println("list contains " + list);

        // for-each was introduced in JDK 1.5
        for (String name : list) {
            System.out.println(name);
            // following throws ConcurrentModificationExceptoin
            // if (name.equalsIgnoreCase("Kumar")) {
            // list.remove(name);
            // }
        }

        // prior to JDK 1.5
        for (int i = 0, j = list.size(); i < j; i++) {
            String name = list.get(i);
            System.out.println(name);
            if (name.equalsIgnoreCase("Kumar")) {
                list.remove(name);
                i--;
                j = list.size();
            }
        }
        System.out.println("list contains " + list);

        Iterator<String> it = list.iterator();
        System.out.println("it is an instanceof type " + it.getClass().getName());
        while (it.hasNext()) {
            String name = it.next();
            System.out.println("name is " + name);
            // following works fine without throwing ConcurrentModificationException
            if (name.equalsIgnoreCase("Kumar")) {
                it.remove();
            }
        }
        System.out.println("list contains " + list);

    }

}
