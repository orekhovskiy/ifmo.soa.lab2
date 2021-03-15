package ru.ifmo.soa_lab2_servcie1.exceptions;


public class NotFoundException extends Exception {
    public NotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
