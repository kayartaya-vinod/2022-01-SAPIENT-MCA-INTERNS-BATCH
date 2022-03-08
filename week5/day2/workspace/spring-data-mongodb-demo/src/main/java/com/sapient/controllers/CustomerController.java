package com.sapient.controllers;

import com.sapient.dao.CustomerRepository;
import com.sapient.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    CustomerRepository repo;

    @GetMapping
    public Page<Customer> getAllCustomers(
            @RequestParam(name = "_page", required = false, defaultValue = "1") Integer page,
            @RequestParam(name = "_limit", required = false, defaultValue = "10") Integer limit) {

        PageRequest p = PageRequest.of(page - 1, limit);
        return this.repo.findAll(p);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneCustomer(@PathVariable String id) {
        Optional<Customer> result = repo.findById(id);
        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
        } else {
            Map<String, Object> resp = new HashMap<>();
            resp.put("message", "No data found for id: " + id);
            resp.put("timestamp", new Date());
            resp.put("status", 404);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resp);
        }
    }

    @PostMapping
    public Customer addNewCustomer(@RequestBody Customer customer){
        customer.setId(null);
        return this.repo.save(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCustomer(@PathVariable String id, @RequestBody Customer customer){
        if(this.repo.existsById(id)) {
            customer.setId(id);
            this.repo.save(customer);
            return ResponseEntity.ok(customer);
        }
        else{
            Map<String, Object> resp = new HashMap<>();
            resp.put("message", "No data found for id: " + id);
            resp.put("timestamp", new Date());
            resp.put("status", 404);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resp);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable String id){
        Optional<Customer> result = this.repo.findById(id);
        if(result.isPresent()){
            Customer customer = result.get();
            this.repo.deleteById(id);
            return ResponseEntity.ok(customer);
        }
        else{
            Map<String, Object> resp = new HashMap<>();
            resp.put("message", "No data found for id: " + id);
            resp.put("timestamp", new Date());
            resp.put("status", 404);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resp);
        }
    }

    // http://localhost:8080/api/customers/search?country=Germany
    @GetMapping("/search")
    public List<Customer> getCustomersFromCountry(@RequestParam String country){
        return this.repo.findByCountry(country);
    }

    @GetMapping("/by-email")
    public Customer getCustomerByEmail(@RequestParam String email){
        return this.repo.findByEmail(email);
    }

    @GetMapping("/by-phone")
    public Customer getCustomerByPhone(@RequestParam String phone){
        return this.repo.customerByPhone(phone);
    }


    @GetMapping("/by-email-phone")
    public Customer getCustomerByPhoneAndEmail(@RequestParam String email, @RequestParam String phone) {
        return this.repo.findByEmailAndPhone(email, phone);
    }









}
