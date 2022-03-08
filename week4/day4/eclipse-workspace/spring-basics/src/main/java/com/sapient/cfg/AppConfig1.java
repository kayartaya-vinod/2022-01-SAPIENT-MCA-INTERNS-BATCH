package com.sapient.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.sapient.dao.ProductDao;
import com.sapient.dao.ProductDaoDummyImpl;
import com.sapient.dao.ProductDaoJdbcImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class AppConfig1 {
	// This class is going to be instantiated by Spring.
	// This class hosts methods returning beans (objects of java classes). These
	// methods should be annotated with @Bean. Spring automatically calls these
	// methods, collects the return values, and keeps them in a container. When ever
	// an app required a bean, it will simply ask the spring container and if such a
	// bean is available, it will be given.

	public AppConfig1() {
		log.debug("AppConfig1 constructor called");
	}

	//@Scope("prototype")
	@Lazy
	@Bean(name = "jdbc")
	public ProductDao jdbcProductDao() {
		log.debug("AppConfig1.jdbcProductDao() called");
		return new ProductDaoJdbcImpl();
	}

	@Lazy
	@Bean(name = "dummy")
	public ProductDao dummyProductDao() {
		log.debug("AppConfig1.dummyProductDao() called");
		return new ProductDaoDummyImpl();
	}
}
