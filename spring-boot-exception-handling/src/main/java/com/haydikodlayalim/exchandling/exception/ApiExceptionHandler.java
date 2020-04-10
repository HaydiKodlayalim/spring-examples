package com.haydikodlayalim.exchandling.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler({EntityNotfoundException.class})
    public String entityNotFound() {
        return "Record not found";
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public String iaException() {
        return "Wrong parameter";
    }
}
