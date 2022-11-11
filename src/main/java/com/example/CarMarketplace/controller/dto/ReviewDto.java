package com.example.CarMarketplace.controller.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class ReviewDto {
    private long id;
    private long userId;
    private long carId;
    private String dateTimeStamp;
    private String reviewText;
}
