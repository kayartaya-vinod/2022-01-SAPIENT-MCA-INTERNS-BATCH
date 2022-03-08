package com.sapient.cfg;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.sapient.entity.Category;
import com.sapient.entity.Product;

@Configuration
@PropertySource("classpath:jdbc-info.properties")
@ComponentScan(basePackages = { "com.sapient.dao" })
public class AppConfig5 {

	@Value("${jdbc.driver-class-name}")
	String driverClassName;
	@Value("${jdbc.connection.url}")
	String url;
	@Value("${jdbc.connection.username}")
	String username;
	@Value("${jdbc.connection.password}")
	String password;

	@Bean
	public BasicDataSource ds() {
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
	public LocalSessionFactoryBean sessionFactory(DataSource ds) {
		LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
		lsfb.setDataSource(ds);
		lsfb.setAnnotatedClasses(Category.class, Product.class);
		
		Properties props = new Properties();

		props.setProperty("hibernate.show_sql", "false");
		props.setProperty("hibernate.format_sql", "true");
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		
		lsfb.setHibernateProperties(props);
		
		return lsfb;
	}
	
	@Bean
	public HibernateTemplate ht(SessionFactory sessionFactory) { // dependency injection by Spring
		return new HibernateTemplate(sessionFactory); // manual wiring by me
	}

}
