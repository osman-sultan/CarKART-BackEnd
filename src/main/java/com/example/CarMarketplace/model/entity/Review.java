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

    @NotEmpty
    private String dateTimeStamp;

    private int likes;
    private int replies;

    public Review(long id, User user, String dateTimeStamp){
        this.id = id;
        this.user = user;
        this.dateTimeStamp = dateTimeStamp;
    }
}
