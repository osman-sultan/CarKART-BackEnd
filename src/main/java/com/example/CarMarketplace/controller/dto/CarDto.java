package com.example.CarMarketplace.controller.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class CarDto {
    private long id;
    private String make;
    private String model;
    private int releaseYear;
    private String fuelType;
    private double price;
    private String vehicleType;
    private double hp;
    private double mileage;
    private String colour;
    private String transmission;
}
