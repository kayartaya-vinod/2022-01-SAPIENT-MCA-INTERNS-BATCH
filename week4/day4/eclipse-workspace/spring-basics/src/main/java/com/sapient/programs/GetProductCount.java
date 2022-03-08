package com.sapient.programs;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sapient.cfg.AppConfig2;
import com.sapient.dao.DaoException;
import com.sapient.dao.ProductDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GetProductCount {

	public static void main(String[] args) throws DaoException {
		
		// a variable representing the spring container
		AnnotationConfigApplicationContext context;
		
		// an object representing spring container, filled with beans from AppConfig1 class
		context = new AnnotationConfigApplicationContext(AppConfig2.class);
		// at this time, spring creates an object of AppCofig1, and calls every method
		// annotated with @Bean, collects the return values, and keeps them in the container.
		// Only singleton beans are created at this time.
		
		log.debug("-".repeat(50));
		
		// getting a bean from spring container (as a factory)
		ProductDao dao = context.getBean("jdbcDao", ProductDao.class); // prototype bean created at this time 
		
		long pc = dao.count();
		log.debug("There are {} products", pc);
		
//		ProductDao dao1 = context.getBean(ProductDao.class); // prototype bean created at this time
//		
//		log.debug("dao==dao1 is {}", dao==dao1);
		
		
		// close context for resource cleanup
		context.close();
	}
}
