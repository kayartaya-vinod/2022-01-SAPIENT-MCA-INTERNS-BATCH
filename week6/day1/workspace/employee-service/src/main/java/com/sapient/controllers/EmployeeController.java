package com.sapient.controllers;

import com.sapient.dao.EmployeeDao;
import com.sapient.entity.Employee;
import com.sapient.service.EmployeeService;
import com.sapient.vob.DepartmentVob;
import com.sapient.vob.EmployeeVob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOne(@PathVariable Integer id) {
        EmployeeVob emp = service.getEmployeeById(id);
        if (emp == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No data found for id " + id);
        }
        return ResponseEntity.ok(emp);
    }


    @GetMapping
    public List<EmployeeVob> getAll() {
        return service.getAll();
    }


}
