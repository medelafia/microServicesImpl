package com.med.securityservice.exceptionHandler;

import com.med.securityservice.error.ErrorDetails;
import com.med.securityservice.exception.BasedException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(BasedException.class)
    public ResponseEntity<ErrorDetails> handleBasedException(BasedException basedException , WebRequest webRequest) {
        ErrorDetails errorDetails = ErrorDetails.builder()
                .url(webRequest.getContextPath())
                .message(basedException.getMessage())
                .timeStamp(Instant.now())
                .build();
        return new ResponseEntity<>(errorDetails , basedException.getStatusCode()) ;
    }
}
