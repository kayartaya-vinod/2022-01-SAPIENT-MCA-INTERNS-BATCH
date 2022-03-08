package com.sapient.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "SHIPPERS")
public class Shipper {
	@Id
	@Column(name = "SHIPPER_ID")
	private Integer id;
	@Column(name = "COMPANY_NAME")
	private String name;
	private String phone;
}
