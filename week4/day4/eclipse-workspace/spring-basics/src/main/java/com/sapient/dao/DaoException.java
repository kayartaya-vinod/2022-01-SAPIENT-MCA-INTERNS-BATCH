package com.sapient.dao;

public class DaoException extends Exception {

	private static final long serialVersionUID = 6636431745219272555L;

	public DaoException() {
		super();
	}

	public DaoException(String message) {
		super(message);
	}

	public DaoException(Throwable cause) {
		super(cause);
	}

}
