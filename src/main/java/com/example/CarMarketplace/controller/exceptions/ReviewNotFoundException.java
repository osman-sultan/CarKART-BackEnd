package com.example.CarMarketplace.controller.exceptions;

public class ReviewNotFoundException extends RuntimeException{
    public ReviewNotFoundException(int id){
        super("Could not find review " + id);
    }
}