package com.sapient.programs;

import org.hibernate.Session;

import com.sapient.entity.Category;
import com.sapient.entity.Product;
import com.sapient.utils.HibernateUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AddProductsToCategory {
	
	public static void main(String[] args) {
		
		Product p1 = new Product();
		p1.setName("Chai");
		p1.setUnitPrice(12.9);
		p1.setDiscontinued(0);
		
		Product p2 = new Product();
		p2.setName("Chang");
		p2.setUnitPrice(25.4);
		p2.setDiscontinued(0);
		
		try(Session session = HibernateUtil.getSession();){
			Category c1 = session.get(Category.class, 1); // c1 is now a persistent object
			p1.setCategory(c1);	// p1 is a transient object
			p2.setCategory(c1); // p2 is a transient object
			
			session.save(p1); // make p1 as persistent object with a meta information as "new"
			session.save(p2); // make p2 as persistent object with a meta information as "new"
			
			session.beginTransaction().commit();
			log.debug("Products data added to db");
		}
		
	}
}
