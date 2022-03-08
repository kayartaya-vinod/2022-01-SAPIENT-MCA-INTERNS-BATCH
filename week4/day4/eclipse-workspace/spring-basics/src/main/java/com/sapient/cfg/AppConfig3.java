package com.sapient.cfg;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.sapient.dao.ProductDaoJdbcImpl;

import lombok.extern.slf4j.Slf4j;

@Configuration
@PropertySource("classpath:jdbc-info.properties")
@Slf4j
public class AppConfig3 {

	@Value("${jdbc.driver-class-name}")
	String driverClassName;
	@Value("${jdbc.connection.url}")
	String url;
	@Value("${jdbc.connection.username}")
	String username;
	@Value("${jdbc.connection.password}")
	String password;

	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource bds = new BasicDataSource();

		bds.setDriverClassName(driverClassName);
		bds.setUrl(url);
		bds.setUsername(username);
		bds.setPassword(password);
		bds.setInitialSize(20);
		bds.setMaxTotal(100);
		bds.setMaxIdle(3);
		bds.setMaxWaitMillis(2000);

		return bds;
	}

	// since spring invokes this method, it is spring's responsibility to pass an
	// argument
	@Bean
	public ProductDaoJdbcImpl dao(DataSource dataSource) { // this method has a dependency on DataSource
		log.debug("AppConfig3.dao() called with {} object", dataSource.getClass().getName());
		return new ProductDaoJdbcImpl(dataSource); // manual wiring / DI
	}
}
