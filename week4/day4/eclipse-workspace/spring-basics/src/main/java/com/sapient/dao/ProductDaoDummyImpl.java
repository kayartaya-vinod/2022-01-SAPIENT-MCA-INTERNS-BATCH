package com.sapient.dao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProductDaoDummyImpl implements ProductDao {

	@Override
	public long count() throws DaoException {
		log.debug("ProductDaoDummyImpl.count() called");
		return 10000;
	}

}
