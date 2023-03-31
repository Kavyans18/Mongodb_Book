package com.pws.DBMongo.exception;

public class NoDataAvailableExcpetion extends RuntimeException{
    String message = "No Books available in database";

    public NoDataAvailableExcpetion(String message){
        super();
        this .message= message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
