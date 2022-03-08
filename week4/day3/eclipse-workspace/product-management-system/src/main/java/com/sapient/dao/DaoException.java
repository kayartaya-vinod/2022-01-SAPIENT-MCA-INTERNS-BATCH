package com.sapient.dao;

public class DaoException extends Exception {

	private static final long serialVersionUID = -7551188171712503098L;

	public DaoException() {
	}

	public DaoException(String message) {
		super(message);
	}

	public DaoException(Throwable cause) {
		super(cause);
	}

}
