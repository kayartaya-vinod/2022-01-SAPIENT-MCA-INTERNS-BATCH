package com.sapient.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="SHIPPERS")
public class Shipper {
    @Id
    @GeneratedValue(generator = "increment")
    @Column(name="SHIPPER_ID")
    private Integer id;
    @Column(name="COMPANY_NAME")
    private String name;
    private String phone;
}
