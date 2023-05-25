package com.example.churchmanagement.exception;

public class PhoneNumberException extends Exception {

    private String message;

    public PhoneNumberException(String message) {
     super(message);
    }
}
