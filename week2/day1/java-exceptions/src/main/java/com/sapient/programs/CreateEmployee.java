package com.sapient.programs;

import com.sapient.entity.Employee;

public class CreateEmployee {

    public static void main(String[] args) {
        Employee e1;

        e1 = new Employee();

        e1.setId(98); // id shoud be > 0
        e1.setName("Kishore"); // length of name should be between 3 and 30 letters
        e1.setSalary(50000);

        System.out.println(e1);

        Employee e2;
        e2 = new Employee(90, "Suresh", 500);
        System.out.println(e2);
    }
}
