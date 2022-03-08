package com.sapient.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Embeddable
public class ContactInfo {
    private String address;
    private String city;
    private String region;
    @Column(name="POSTAL_CODE")
    private String postalCode;
    private String country;
}
