package com.sapient.programs;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sapient.cfg.AppConfig5;
import com.sapient.dao.DaoException;
import com.sapient.dao.ProductDao;
import com.sapient.entity.Product;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GetProductById {

	public static void main(String[] args) throws DaoException {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig5.class);
		ProductDao dao = ctx.getBean("htDao", ProductDao.class);
		Product p1 = dao.findById(12);
		ctx.close();
		log.debug("p1 is {}", p1);
	}
}
