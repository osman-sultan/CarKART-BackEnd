package com.example.CarMarketplace.controller.exceptions;

public class CarNotFoundException extends RuntimeException{
    public CarNotFoundException(int id){
        super("Could not find car " + id);
    }
}