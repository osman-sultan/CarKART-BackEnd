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
@Table(name = "Review_E")
public class Review {

    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "carId")
    private Car car;

    @NotEmpty
    private String dateTimeStamp;

    @NotEmpty
    private String reviewText;

    private int likes;
    private int replies;

    public Review(long id, User user, String dateTimeStamp, String reviewText){
        this.id = id;
        this.user = user;
        this.dateTimeStamp = dateTimeStamp;
        this.reviewText = reviewText;
    }
}
