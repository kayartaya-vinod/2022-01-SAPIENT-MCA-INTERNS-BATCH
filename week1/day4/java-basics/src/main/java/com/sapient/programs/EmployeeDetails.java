package com.sapient.programs;

import com.sapient.entity.Employee;

public class EmployeeDetails {

    public static void main(String[] args) {

        Employee e1 = new Employee();
        Employee e2 = new Employee(1122, "John Doe", 23000.0);

        e1.setId(7654);
        e1.setName("John Miller");
        e1.setSalary(45000.0);

        System.out.println(e1);
        System.out.println(e2);
    }

}
