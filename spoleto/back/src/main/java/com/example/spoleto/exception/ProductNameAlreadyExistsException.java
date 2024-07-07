package com.example.spoleto.exception;

public class ProductNameAlreadyExistsException extends RuntimeException{
    public ProductNameAlreadyExistsException(String message) {
        super(message);
    }
}
