package com.sapient.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sapient.entity.Customer;
import com.sapient.utils.DbUtil;

public class CustomerDaoJdbcImpl implements CustomerDao {

	@Override
	public Customer findById(int id) throws DaoException {
		String sql = "select * from customers where id = ?";

		try (Connection conn = DbUtil.createConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {

			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return fromResultSet(rs);
			}

		} catch (Exception ex) {
			throw new DaoException(ex); // exception funnelling
		}

		return null;
	}

	@Override
	public List<Customer> findByState(String state) throws DaoException {
		String sql = "select * from customers where state = ?";
		List<Customer> list = new ArrayList<>();

		try (Connection conn = DbUtil.createConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {

			stmt.setString(1, state);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				list.add(fromResultSet(rs));
			}

		} catch (Exception ex) {
			throw new DaoException(ex); // exception funnelling
		}

		return list;
	}

	Customer fromResultSet(ResultSet rs) throws SQLException {
		Customer c = new Customer();
		c.setId(rs.getInt("id"));
		c.setName(rs.getString("name"));
		c.setEmail(rs.getString("email"));
		c.setPhone(rs.getString("phone"));
		c.setCity(rs.getString("city"));
		c.setState(rs.getString("state"));
		return c;
	}
}
