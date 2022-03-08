package com.sapient.programs;

import org.hibernate.Session;

import com.sapient.entity.Product;
import com.sapient.utils.HibernateUtil;

public class GetProductById {

	public static void main(String[] args) {
		
		Product p1 = null;
		try (Session session = HibernateUtil.getSession();) {
			p1 = session.get(Product.class, 1); // gets the product and corresponding category using a join statement
		} // session.close() is called; hence DB connection is lost
		
		// there is no problem in accessing p1's data, which is already in the JVM
		System.out.println("Name = " + p1.getName());
		System.out.println("Unit price = $" + p1.getUnitPrice());
		System.out.println("Category = " + p1.getCategory().getName());
		System.out.println("Description = " + p1.getCategory().getDescription());

	}
}
