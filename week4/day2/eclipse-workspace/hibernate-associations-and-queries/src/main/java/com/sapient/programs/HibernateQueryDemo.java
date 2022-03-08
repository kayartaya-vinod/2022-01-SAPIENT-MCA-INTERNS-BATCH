package com.sapient.programs;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.sapient.entity.Product;
import com.sapient.utils.HibernateUtil;

public class HibernateQueryDemo {

	public static void main(String[] args) {
		// getAllProducts();
		// getProductsBySupplierId();
		// getProductsByPriceRange();
		getDiscontinuedProductNames();
	}

	private static void getDiscontinuedProductNames() {
		String hql = "select name from Product where discontinued=1";
		try (Session session = HibernateUtil.getSession()) {
			Query<String> qry = session.createQuery(hql, String.class);
			qry.getResultList().forEach(System.out::println);
		}
	}

	static void getProductsByPriceRange() {
		String hql = "from Product where unitPrice between ?0 and ?1";
		try (Session session = HibernateUtil.getSession()) {
			Query<Product> qry = session.createQuery(hql, Product.class);
			qry.setParameter(0, 50.0);
			qry.setParameter(1, 150.0);
			List<Product> list = qry.list();
			list.forEach(HibernateQueryDemo::displayProduct);
		}
	}

	static void getProductsBySupplierId() {
		// String hql = "from Product where supplierId = ?0";
		String hql = "from Product where supplierId = :SUP_ID";
		try (Session session = HibernateUtil.getSession()) {
			Query<Product> qry = session.createQuery(hql, Product.class);
			// qry.setParameter(0, 7);
			qry.setParameter("SUP_ID", 7);
			List<Product> list = qry.list();
			list.forEach(HibernateQueryDemo::displayProduct);
		}
	}

	static void getAllProducts() {
		try (Session session = HibernateUtil.getSession()) {
			// String hql = "select p from com.sapient.entity.Product p";
			String hql = "from Product";
			Query<Product> qry = session.createQuery(hql, Product.class); // prepare sql
			List<Product> list = qry.getResultList(); // actual SQL command is sent to the db
			list.forEach(HibernateQueryDemo::displayProduct);
		}
	}

	private static void displayProduct(Product p) {
		System.out.printf("ID: %d, Name: %s, Price: $%.2f, Category: %s\n", p.getId(), p.getName(), p.getUnitPrice(),
				p.getCategory().getName());
	}
}
