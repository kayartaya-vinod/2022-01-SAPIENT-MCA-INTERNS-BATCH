package com.sapient.programs;

import org.hibernate.Session;

import com.sapient.entity.Category;
import com.sapient.utils.HibernateUtil;

public class GetOneCategoryAndCorrespondingProducts {

	public static void main(String[] args) {
		Category c1 = null;
		
		try (Session session = HibernateUtil.getSession();) {
			c1 = session.get(Category.class, 1); // gets only the Category instance; not corresponding products!!!
			// No problem in accessing data from c1
			System.out.println("Category name is: " + c1.getName());
			System.out.println("Description is: " + c1.getDescription());
			
			// c1.getProducts() is not fetched yet (because of lazy fetch);
			// needs a DB connection to go and get data; but DB is closed;
			System.out.println("Total products is: " + c1.getProducts().size()); // now gets the products from the db
			c1.getProducts().forEach(p -> System.out.println(p.getName() + " --> $" + p.getUnitPrice()));
		}// session.close() is called; no open DB connection.
		
	}
}
