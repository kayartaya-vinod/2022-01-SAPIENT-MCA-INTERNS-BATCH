package com.sapient.dao;

import java.util.List;

import org.hibernate.Session;

import com.sapient.entity.Category;
import com.sapient.utils.HibernateUtil;

public class CategoryDaoHibernateImpl implements CategoryDao {

	@Override
	public List<Category> findAll() throws DaoException {
		try (Session session = HibernateUtil.getSession();) {
			return session.createQuery("from Category", Category.class).getResultList();
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
	}

}
