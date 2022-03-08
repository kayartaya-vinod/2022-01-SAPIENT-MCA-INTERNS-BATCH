package com.sapient.entity;

public class InvalidNameException extends RuntimeException {

    public InvalidNameException() {
    }

    public InvalidNameException(String message) {
        super(message);
    }

    public InvalidNameException(Throwable cause) {
        super(cause);
    }

}
