package com.sapient.programs;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sapient.entity.Category;
import com.sapient.utils.HibernateUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreateCategory {

	public static void main(String[] args) {
		
		Category c1 = new Category();
		
		c1.setName("Beverages");
		c1.setDescription("Drinks, cofee, tea etc");
		
		try(Session session = HibernateUtil.getSession();){
			
			Transaction tx = session.beginTransaction();
			
			try {
				session.save(c1);
				tx.commit(); // SQL command/s sent to the db server 
				log.debug("{} saved", c1);
			}
			catch(Exception ex) {
				tx.rollback();
				log.warn("Error while saving category object", ex);
			}
		}
		
	}
}
