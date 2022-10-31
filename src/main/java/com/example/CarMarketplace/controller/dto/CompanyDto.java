package com.example.CarMarketplace.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CompanyDto {
    private String make;
    private String country;
    private int yearFounded;
    private String hq;
    private String logoURL;
}
