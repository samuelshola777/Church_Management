package com.example.churchmanagement.exception;

public class PasswordException extends Exception {
    private String message;
    public PasswordException(String message){
        super(message);
    }
}
