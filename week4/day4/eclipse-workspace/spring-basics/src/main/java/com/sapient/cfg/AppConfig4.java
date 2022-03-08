package com.sapient.cfg;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:jdbc-info.properties")
// scans the given packages for components and instantiates them, keeps them in the spring container
@ComponentScan(basePackages = { "com.sapient.dao" })
public class AppConfig4 {

	@Value("${jdbc.driver-class-name}")
	String driverClassName;
	@Value("${jdbc.connection.url}")
	String url;
	@Value("${jdbc.connection.username}")
	String username;
	@Value("${jdbc.connection.password}")
	String password;

	@Bean
	public BasicDataSource ds2() {
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

	@Bean
	public BasicDataSource ds1() {
		BasicDataSource bds = new BasicDataSource();

		bds.setDriverClassName("org.h2.Driver");
		bds.setUrl("jdbc:h2:tcp://localhost/~/trainingdb");
		bds.setUsername(username);
		bds.setPassword(password);
		bds.setInitialSize(20);
		bds.setMaxTotal(100);
		bds.setMaxIdle(3);
		bds.setMaxWaitMillis(2000);

		return bds;
	}
}
