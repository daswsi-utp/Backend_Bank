package com.bank.serviceuser.exception;

public class InvalidDniFormatException extends RuntimeException {
    public InvalidDniFormatException(String message) {
        super(message);
    }
}
