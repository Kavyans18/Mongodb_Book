package com.pws.DBMongo.exception;

public class IdNotFoundException extends RuntimeException {
    String message = "Book id not found";

    public IdNotFoundException(String message) {
        super();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
