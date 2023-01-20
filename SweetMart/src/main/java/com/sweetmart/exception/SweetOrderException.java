package com.sweetmart.exception;

public class SweetOrderException extends RuntimeException {

    public SweetOrderException() {
    }

    public SweetOrderException(String message) {
        super(message);
    }
}
