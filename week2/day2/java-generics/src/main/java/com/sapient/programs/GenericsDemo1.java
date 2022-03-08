package com.sapient.programs;

import com.sapient.entity.Circle;
import com.sapient.entity.Test;
import com.sapient.entity.Util;

public class GenericsDemo1 {

    public static void main(String[] args) {

        Test<String> t1 = new Test<>("Vinod");
        Test<Integer> t2 = new Test<>(123);
        Test<Double> t3 = new Test<>(12.3);
        

        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);

        Util.displayInfo(12);
        Util.displayInfo("Vinod");
        Util.displayInfo(100.20);

        Circle c1 = new Circle();
        Util.displayInfo(c1);
    }
}
