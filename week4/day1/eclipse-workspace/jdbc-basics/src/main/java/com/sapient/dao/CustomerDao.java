package com.sapient.dao;

import java.util.List;

import com.sapient.entity.Customer;

public interface CustomerDao {
	// CRUD operations
	/**
	 * This method should check and retrieve the customer object from the underlying
	 * storage mechanism
	 * 
	 * @param id customer id to look for
	 * @return null if no customer is found, or the actual customer object
	 * @throws DaoException converting any caught exception
	 */
	public Customer findById(int id) throws DaoException;

	// QUERY operations

	/**
	 * 
	 * @param state state from the you want customers
	 * @return empty list when no customers found for the given state, or list of
	 *         customer instances for the given state
	 * @throws DaoException
	 */
	public List<Customer> findByState(String state) throws DaoException;

}
