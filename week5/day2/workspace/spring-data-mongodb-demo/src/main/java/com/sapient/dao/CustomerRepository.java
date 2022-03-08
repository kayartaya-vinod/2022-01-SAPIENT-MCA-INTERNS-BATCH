package com.sapient.dao;

import com.sapient.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    public List<Customer> findByCountry(String country);

    // getCustomerByEmail
    public Customer findByEmail(String email);

    @Query("{phone: ?0}")
    public Customer customerByPhone(String phone);

    public Customer findByEmailAndPhone(String email, String phone);
}
