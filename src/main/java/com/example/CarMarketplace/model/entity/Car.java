package com.example.CarMarketplace.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Car_E")
public class Car {
    @Id
    @NotEmpty
    private int id;

    @ManyToOne
    @JoinColumn(name = "make")
    private Company company;

    @NotEmpty
    private String model;

    @NotEmpty
    private int releaseYear;

    @NotEmpty
    private String fuelType;

    @NotEmpty
    private double price;

    @NotEmpty
    private String vehicleType;

    @NotEmpty
    private double hp;

    @NotEmpty
    private double mileage;

    @NotEmpty
    private String colour;

    @NotEmpty
    private String transmission;

    public Car(int id, Company company, String model, int releaseYear){
        this.id = id;
        this.company = company;
        this.model = model;
        this.releaseYear = releaseYear;
    }


}
