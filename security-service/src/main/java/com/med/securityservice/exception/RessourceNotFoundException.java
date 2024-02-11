package com.med.securityservice.exception;

import org.springframework.http.HttpStatus;

public class RessourceNotFoundException extends BasedException{

    public RessourceNotFoundException(String message) {
        super(message);
    }
    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.NOT_FOUND;
    }
}
