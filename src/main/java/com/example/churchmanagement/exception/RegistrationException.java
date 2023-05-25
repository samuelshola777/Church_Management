package com.example.churchmanagement.exception;

public class RegistrationException extends Exception {

    private String message;
    public RegistrationException(String message){
        super(message);
    }

}
