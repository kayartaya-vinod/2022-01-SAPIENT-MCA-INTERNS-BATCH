package com.sapient.controllers;

import com.sapient.dao.CustomerRepository;
import com.sapient.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    CustomerRepository repo;

    @GetMapping(produces = "application/json")
    public Iterable<Customer> getAllCustomers(){
        return this.repo.findAll();
    }

}
