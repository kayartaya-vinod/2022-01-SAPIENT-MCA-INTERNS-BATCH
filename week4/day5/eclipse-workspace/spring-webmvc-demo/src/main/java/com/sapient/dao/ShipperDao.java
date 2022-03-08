package com.sapient.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.sapient.entity.Shipper;

public interface ShipperDao {
	// CRUD operations
	@Transactional(readOnly = false)
	public void create(Shipper shipper) throws DaoException;
	
	public Shipper findById(Integer id) throws DaoException;
	
	@Transactional(readOnly = false)
	public void update(Shipper shipper) throws DaoException;
	
	@Transactional(readOnly = false)
	public void delete(Integer id) throws DaoException;
	
	// Query operations
	public List<Shipper> findAll() throws DaoException;
}
