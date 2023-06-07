package com.example.churchmanagement.exception;

public class PasswordException extends RuntimeException {
    private String message;
    public PasswordException(String message){
        super(message);
    }
}
