package com.sapient.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="CUSTOMERS")
public class Customer {
    @Id
    @Column(name="CUSTOMER_ID")
    private String customerId;
    @Column(name="COMPANY_NAME")
    private String companyName;
    @Column(name="CONTACT_NAME")
    private String contactName;
    @Column(name="CONTACT_TITLE")
    private String contactTitle;

    @Embedded
    private ContactInfo contactInfo;

    private String phone;
    private String fax;
}
