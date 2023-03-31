package com.pws.DBMongo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class ExceptionController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<String> handleIdNotFoundExceptionHandler(IdNotFoundException exception) {
        exception.getMessage();
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoDataAvailableExcpetion.class)
    public ResponseEntity<String> handleNoDataAvailableException(NoDataAvailableExcpetion exception) {
        exception.getMessage();
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
