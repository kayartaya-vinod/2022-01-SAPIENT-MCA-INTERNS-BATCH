package com.sapient.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

// @Repository --> classes in the DAO (or repository) layer
// @Service --> classes in the Service (or business) layer
// @Controller --> classes in the web layer
// @RestController --> classes in the web layer in a REST application
// @Configuration --> any configuration classes (like AppConfig1, ...)
// @Component --> any class that do not qualify for any of the above
@Repository("jdbcDao")
@Slf4j
public class ProductDaoJdbcImpl implements ProductDao {

	// dependencies
	private String driverClassName;
	private String url;
	private String username;
	private String password;

	// db connection pool, represented by an interface called DataSource
	@Autowired(required = false)
	@Qualifier("ds2")
	private DataSource dataSource;

	public ProductDaoJdbcImpl() {
	}

	// can be used for dependency injection
	public ProductDaoJdbcImpl(String driverClassName, String url, String username, String password) {
		this.driverClassName = driverClassName;
		this.url = url;
		this.username = username;
		this.password = password;
	}

	// can be used for DI
	public ProductDaoJdbcImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	// writable properties; used for dependency injection; a.k.a mutators
	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// can be used for DI
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	Connection createConnection() throws ClassNotFoundException, SQLException {

		log.debug("Inside ProductDaoJdbcImpl.createConnection, dataSource is {}", dataSource);
		
		if (this.dataSource != null) {
			return this.dataSource.getConnection();
		}

		Class.forName(driverClassName);
		return DriverManager.getConnection(url, username, password);
	}

	@Override
	public long count() throws DaoException {
		log.debug("ProductDaoJdbcImpl.count() called");

		try (Connection conn = this.createConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select count(*) as CNT from PRODUCTS");) {
			
			log.debug("rs is an instance of type {}", rs.getClass().getName());
			
			rs.next();
			return rs.getLong("CNT");
		} catch (Exception ex) {
			log.warn("Error in ProductDaoJdbcImpl.count()", ex);
			throw new DaoException(ex);
		}

	}

}
