package com.example.CarMarketplace.controller;

import com.example.CarMarketplace.controller.dto.ReviewDto;
import com.example.CarMarketplace.controller.exceptions.UserNotFoundException;
import com.example.CarMarketplace.controller.exceptions.ReviewNotFoundException;
import com.example.CarMarketplace.model.entity.User;
import com.example.CarMarketplace.model.entity.Review;
import com.example.CarMarketplace.model.repository.ReviewRepository;
import com.example.CarMarketplace.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ReviewController {

    @Autowired
    private final ReviewRepository repository;

    @Autowired
    private UserRepository userRepository;

    public ReviewController(ReviewRepository repository){
        this.repository = repository;
    }

    @GetMapping("/reviews")
    List<Review> retrieveAllReviews(){
        return repository.findAll();
    }

    @GetMapping("/reviews/{id}")
    Review retrieveReview(@PathVariable("id") int id){
        return repository.findById(id).orElseThrow(
                () -> new ReviewNotFoundException(id)
        );
    }

    @PostMapping("/reviews")
    Review createReview(@RequestBody ReviewDto reviewDto) {
        Review newReview = new Review();
        newReview.setId(reviewDto.getId());
        newReview.setDateTimeStamp(reviewDto.getDateTimeStamp());
        User user = userRepository.findById(reviewDto.getUserId()).orElseThrow(
                () -> new UserNotFoundException(reviewDto.getUserId()));
        newReview.setUser(user);
        return repository.save(newReview);
    }
}