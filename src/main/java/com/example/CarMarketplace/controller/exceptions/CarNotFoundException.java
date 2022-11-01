package com.example.CarMarketplace.controller.exceptions;

public class CarNotFoundException extends RuntimeException{
    public CarNotFoundException(Long id){
        super("Could not find car " + id);
    }
}