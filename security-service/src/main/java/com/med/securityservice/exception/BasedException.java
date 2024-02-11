package com.med.securityservice.exception;

import org.springframework.http.HttpStatus;

public abstract class BasedException extends RuntimeException {
    public BasedException(String message) {
        super(message);
    }
    public abstract HttpStatus getStatusCode() ;
}
