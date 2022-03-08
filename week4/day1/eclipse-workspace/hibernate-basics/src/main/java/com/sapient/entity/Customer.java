package com.sapient.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="CUSTOMERS")
public class Customer {
	@Id
	private int id;
	private String name;
	private String email;
	private String phone;
	private String city;
	private String state;
}
