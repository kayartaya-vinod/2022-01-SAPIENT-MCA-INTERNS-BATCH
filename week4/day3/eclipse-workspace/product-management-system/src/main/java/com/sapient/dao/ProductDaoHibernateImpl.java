package com.sapient.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.sapient.entity.Product;
import com.sapient.utils.HibernateUtil;

public class ProductDaoHibernateImpl implements ProductDao {

	@Override
	public Product create(Product product) throws DaoException {
		try (Session session = HibernateUtil.getSession();) {
			
			Integer id = (Integer) session.save(product);
			
			session.beginTransaction().commit();
			
			product.setId(id);
			return product;
		} // session.close() called here automatically
		catch (Exception ex) {
			throw new DaoException(ex);
		}
	}

	@Override
	public Product findById(Integer id) throws DaoException {
		try (Session session = HibernateUtil.getSession();) {
			return session.get(Product.class, id);
		} // session.close() called here automatically
		catch (Exception ex) {
			throw new DaoException(ex);
		}
	}

	@Override
	public Product update(Product product) throws DaoException {
		return null;
	}

	@Override
	public List<Product> findAll() throws DaoException {
		try (Session session = HibernateUtil.getSession();) {
			return session.createQuery("from Product", Product.class).getResultList();
		} // session.close() called here automatically
		catch (Exception ex) {
			throw new DaoException(ex);
		}
	}

	@Override
	public List<Product> findByPriceRange(Double min, Double max) throws DaoException {
		try (Session session = HibernateUtil.getSession();) {
			String hql = "from Product where unitPrice between ?0 and ?1 order by unitPrice";
			Query<Product> qry = session.createQuery(hql, Product.class);

			qry.setParameter(0, min);
			qry.setParameter(1, max);

			return qry.getResultList();

		} // session.close() called here automatically
		catch (Exception ex) {
			throw new DaoException(ex);
		}
	}

}
