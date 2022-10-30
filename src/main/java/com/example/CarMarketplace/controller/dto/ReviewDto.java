package com.example.CarMarketplace.controller.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class ReviewDto {
    private int id;
    private int userId;
    private String dateTimeStamp;
}
