package com.example.churchmanagement.exception;

public class InvalidAccountException extends  RuntimeException{
    public InvalidAccountException(String message){
        super(message);
    }
}
