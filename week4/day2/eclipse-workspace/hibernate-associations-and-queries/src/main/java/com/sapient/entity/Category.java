package com.sapient.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "CATEGORIES")
@ToString(exclude = { "products" }) // avoid recursion
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private Integer id;
	@Column(name = "category_name")
	private String name;
	private String description;

	// ONE category has MANY products
	// by default fetch-type is LAZY
	// @JoinColumn(name="category_id") // foreign key in "PRODUCTS" table (creates,
	// if such column does not exist)
	@OneToMany(mappedBy = "category") // get the join column information from the "category"
										// field of "Product" class
	private List<Product> products;
}
