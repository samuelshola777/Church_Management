package com.example.churchmanagement.exception;

public class EmailAlreadyInUseException extends RuntimeException {
    public EmailAlreadyInUseException( String emailAlreadyInUse) {
        super(emailAlreadyInUse);
    }
}
