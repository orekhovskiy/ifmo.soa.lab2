package ru.ifmo.soa_lab2_servcie1.exceptions;

public class WrongArgumentException extends Exception {
    public WrongArgumentException(String errorMessage) {
        super(errorMessage);
    }
}
