package com.sapient.controllers;

import com.sapient.dao.DepartmentDao;
import com.sapient.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    DepartmentDao dao;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOne(@PathVariable Integer id){
        Optional<Department> result = dao.findById(id);
        if(result.isPresent()){
            return ResponseEntity.ok(result.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No data found for id " + id);
    }

    @GetMapping
    public Iterable<Department> getAll(){
        return dao.findAll();
    }
}
