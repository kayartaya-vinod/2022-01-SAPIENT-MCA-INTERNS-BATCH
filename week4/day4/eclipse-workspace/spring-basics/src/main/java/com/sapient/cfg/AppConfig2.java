package com.sapient.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.sapient.dao.ProductDao;
import com.sapient.dao.ProductDaoJdbcImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class AppConfig2 {
	@Lazy
	@Bean(name = "jdbcDao")
	public ProductDao jdbcDao() {
		log.debug("AppConfig1.jdbcDao() called");
		ProductDaoJdbcImpl dao = new ProductDaoJdbcImpl();

		// manual wiring of dependencies via setters (can also be done using overloaded
		// constructor, if present)
		dao.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dao.setUrl("jdbc:mysql://localhost/northwind");
		dao.setUsername("root");
		dao.setPassword("Welcome#123");

		return dao;
	}
}
