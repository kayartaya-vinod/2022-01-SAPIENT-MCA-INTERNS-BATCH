package com.sapient.entity;

public class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee() {
    }

    public Employee(int id, String name, double salary) {
        setId(id);
        setName(name);
        setSalary(salary);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        // before the assignment, we can use custom logic for validation
        if (id < 0) {
            throw new InvalidIdException("ID cannot be negative or zero");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() < 3 || name.length() > 30) {
            throw new InvalidNameException("Name must be with in 3 to 30 letters");
        }
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {

        if (salary < 15000 || salary > 500000) {
            throw new InvalidSalaryException("Salary should be between Rs.15000 and Rs.500000");
        }

        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
    }

}
