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
@Table(name = "Company_E")
public class Company {

    @Id
    @NotEmpty
    private String make;

    @NotEmpty
    private String country;

    @NotEmpty
    private int yearFounded;

    @NotEmpty
    private String hq;

    @NotEmpty
    private String logoURL;

    public Company(String make) {
        this.make = make;
    }
}
