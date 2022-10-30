package com.example.CarMarketplace.controller.exceptions;

public class CompanyNotFoundException extends RuntimeException{
    public CompanyNotFoundException(String make){
        super("Could not find company " + make);
    }
}
