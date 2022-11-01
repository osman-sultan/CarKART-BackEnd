package com.example.CarMarketplace.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Car_E")
public class Car {
    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name = "make")
    private Company company;

    @NotEmpty
    private String model;

    private int releaseYear;

    @NotEmpty
    private String fuelType;

    private double price;

    @NotEmpty
    private String vehicleType;

    private double hp;

    private double mileage;

    @NotEmpty
    private String colour;

    @NotEmpty
    private String transmission;

    public Car(long id, Company company, String model, int releaseYear){
        this.id = id;
        this.company = company;
        this.model = model;
        this.releaseYear = releaseYear;
    }


}
