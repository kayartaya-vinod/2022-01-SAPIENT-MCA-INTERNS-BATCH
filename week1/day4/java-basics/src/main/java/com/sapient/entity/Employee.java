package com.sapient.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {
    private int id;
    private String name;
    private double salary;

    // write your own setter; lombok doesn't add this setter again
    public void setSalary(double salary) {
        if (salary < 15000 || salary > 500000) {
            throw new RuntimeException("Salary must be between 15000 and 500000");
        }
        this.salary = salary;
    }
}
