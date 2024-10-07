package com.springCrud.example.SpringCrudOperations.advices;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleResourseNotFound(NoSuchElementException exception)
    {
        return new ResponseEntity<>("Resourse you requested, not Found" , HttpStatus.NOT_FOUND);
    }
}
