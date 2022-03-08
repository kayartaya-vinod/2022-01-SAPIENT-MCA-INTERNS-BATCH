package com.sapient.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.sapient.entity.Shipper;

@Repository("shipperDao")
public class ShipperDaoImpl implements ShipperDao {

	@Autowired
	HibernateTemplate template;

	@Override
	public void create(Shipper shipper) throws DaoException {
		try {
			template.persist(shipper);
		} catch (DataAccessException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public Shipper findById(Integer id) throws DaoException {
		try {
			return template.get(Shipper.class, id);
		} catch (DataAccessException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public void update(Shipper shipper) throws DaoException {
		try {
			template.merge(shipper);
		} catch (DataAccessException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public void delete(Integer id) throws DaoException {
		try {
			Shipper sh = this.findById(id);
			if (sh != null) {
				template.delete(sh);
			} else {
				throw new DaoException("No data found for id: " + id);
			}
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<Shipper> findAll() throws DaoException {
		try {
			return (List<Shipper>) template.find("from Shipper order by id");
		} catch (DataAccessException e) {
			throw new DaoException(e);
		}
	}

}
