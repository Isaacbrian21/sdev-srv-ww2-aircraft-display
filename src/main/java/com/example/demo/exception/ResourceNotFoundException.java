package com.example.demo.exception;

public class ResourceNotFoundException extends RuntimeException {

    // Construtores para a exceção personalizada
    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
