package com.sapient.controllers;

import com.sapient.dao.CustomerRepository;
import com.sapient.entity.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/customers")
@Slf4j
public class CustomerController {

    @Autowired
    private CustomerRepository repo;

//    @Autowired
//    public void init(CustomerRepository repo){
//        log.debug("CustomerController.init() called");
//        this.repo = repo;
//    }

    @GetMapping
    public Map<String, Object> getAll(Principal user) {
        Map<String, Object> map = new HashMap<>();
        map.put("username", user.getName());
        map.put("content", repo.findAll());
        return map;
    }
}
