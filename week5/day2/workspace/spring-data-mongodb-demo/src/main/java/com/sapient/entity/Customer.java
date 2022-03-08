package com.sapient.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "customers")
public class Customer {
    @Id
    private String id;
    private String firstname;
    private String lastname;
    private String gender;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String zipcode;
    private String country;
}
