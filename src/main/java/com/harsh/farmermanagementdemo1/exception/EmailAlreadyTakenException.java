package com.harsh.farmermanagementdemo1.exception;

public class EmailAlreadyTakenException extends RuntimeException{
    public EmailAlreadyTakenException(String email){
        super("Email Already Registered '"+email+"' .\n Please try again with Different Email Id");
    }
    public EmailAlreadyTakenException(){

    }
}

