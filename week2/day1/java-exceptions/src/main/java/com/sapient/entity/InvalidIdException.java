package com.sapient.entity;

public class InvalidIdException extends RuntimeException {

    public InvalidIdException() {
    }

    public InvalidIdException(String message) {
        super(message);
    }

    public InvalidIdException(Throwable cause) {
        super(cause);
    }

}
