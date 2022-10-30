package com.example.CarMarketplace.controller.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(int id){
        super("Could not find user " + id);
    }
}
