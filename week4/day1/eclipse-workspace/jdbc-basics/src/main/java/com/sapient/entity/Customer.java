package com.sapient.entity;

import lombok.Data;

@Data
public class Customer {
	private int id;
	private String name;
	private String email;
	private String phone;
	private String city;
	private String state;
}
