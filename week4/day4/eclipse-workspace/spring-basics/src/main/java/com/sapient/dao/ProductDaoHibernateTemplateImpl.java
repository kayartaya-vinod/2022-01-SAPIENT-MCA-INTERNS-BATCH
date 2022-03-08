package com.sapient.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.sapient.entity.Product;

@Repository("htDao")
public class ProductDaoHibernateTemplateImpl implements ProductDao {
	
	// HibernateTemplate internally uses/creates a Session object. 
	// For this, it DEPENDS on Hibernate's SessionFactory
	@Autowired(required = false)
	HibernateTemplate template;

	
	// ProductDaoHibernateTemplateImpl depends on HibernateTemplate
	// HibernateTemplate depends on SessionFactory
	// SessionFactory depends on DataSource (connection pool)
	
	
	@Override
	public Product create(Product product) throws DaoException {
		template.persist(product); // new id will be assigned by spring to "product"
		return product;
	}

	@Override
	public Product update(Product product) throws DaoException {
		return template.merge(product);
	}

	@Override
	public Product findById(Integer id) throws DaoException {
		return template.get(Product.class, id);
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Product> findAll() throws DaoException {
		return (List<Product>) template.find("from Product");
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Product> findByPriceRange(Double min, Double max) throws DaoException {
		return (List<Product>) template.find("from Product where unitPrice between ? and ?", min, max);
	}

	@Override
	public long count() throws DaoException {
		return 0;
	}

}
