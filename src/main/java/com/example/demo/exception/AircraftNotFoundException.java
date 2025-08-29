package com.example.demo.exception;

public class AircraftNotFoundException extends  RuntimeException {

    // Construtores para a exceção personalizada
    public AircraftNotFoundException(String message) {
        super(message);
    }

    public AircraftNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
