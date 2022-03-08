package com.sapient.dao;

import com.sapient.entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {
    public List<Employee> findAll();
}
