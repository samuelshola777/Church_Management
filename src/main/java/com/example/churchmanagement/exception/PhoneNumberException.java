package com.example.churchmanagement.exception;

public class PhoneNumberException extends RuntimeException {

    private String message;

    public PhoneNumberException(String message) {
     super(message);
    }
}
