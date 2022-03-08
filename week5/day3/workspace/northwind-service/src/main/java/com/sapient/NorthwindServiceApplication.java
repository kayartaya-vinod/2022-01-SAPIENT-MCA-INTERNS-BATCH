package com.sapient;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class NorthwindServiceApplication {

	@Bean
	public DataSource dataSource(){
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		bds.setUrl("jdbc:mysql://localhost/northwind");
		bds.setUsername("root");
		bds.setPassword("Welcome#123");
		return bds;
	}

	public static void main(String[] args) {
		SpringApplication.run(NorthwindServiceApplication.class, args);
	}

}
