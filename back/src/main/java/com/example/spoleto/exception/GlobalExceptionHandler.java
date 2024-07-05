package com.example.spoleto.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ProductNameAlreadyExistsException.class)
    public ResponseEntity<String> handleProductNameAlreadyExistsException(ProductNameAlreadyExistsException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
