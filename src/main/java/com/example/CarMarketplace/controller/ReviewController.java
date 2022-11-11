package com.example.CarMarketplace.controller;

import com.example.CarMarketplace.controller.dto.CarDto;
import com.example.CarMarketplace.controller.dto.ReviewDto;
import com.example.CarMarketplace.controller.exceptions.CarNotFoundException;
import com.example.CarMarketplace.controller.exceptions.CompanyNotFoundException;
import com.example.CarMarketplace.controller.exceptions.UserNotFoundException;
import com.example.CarMarketplace.controller.exceptions.ReviewNotFoundException;
import com.example.CarMarketplace.model.entity.Car;
import com.example.CarMarketplace.model.entity.Company;
import com.example.CarMarketplace.model.entity.User;
import com.example.CarMarketplace.model.entity.Review;
import com.example.CarMarketplace.model.repository.CarRepository;
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

    @Autowired
    private CarRepository carRepository;

    public ReviewController(ReviewRepository repository){
        this.repository = repository;
    }

    @GetMapping("/reviews")
    List<Review> retrieveAllReviews(){
        return repository.findAll();
    }

    @GetMapping("/reviews/{id}")
    Review retrieveReview(@PathVariable("id") Long id){
        return repository.findById(id).orElseThrow(
                () -> new ReviewNotFoundException(id)
        );
    }

    @PostMapping("/reviews")
    Review createReview(@RequestBody ReviewDto reviewDto) {
        Review newReview = new Review();
        newReview.setId(reviewDto.getId());
        newReview.setDateTimeStamp(reviewDto.getDateTimeStamp());
        newReview.setReviewText(reviewDto.getReviewText());
        User user = userRepository.findById(reviewDto.getUserId()).orElseThrow(
                () -> new UserNotFoundException(reviewDto.getUserId()));
        newReview.setUser(user);
        Car car = carRepository.findById(reviewDto.getCarId()).orElseThrow(
                () -> new CarNotFoundException(reviewDto.getCarId()));
        newReview.setCar(car);
        return repository.save(newReview);
    }

    @PutMapping("/reviews/{id}")
    Review updateReviews(@RequestBody ReviewDto reviewDto, @PathVariable("id") Long id) {
        return repository.findById(id)
                .map(review -> {
                    User user = userRepository.findById(reviewDto.getUserId()).orElseThrow(
                            () -> new UserNotFoundException(reviewDto.getUserId()));
                    review.setUser(user);
                    Car car = carRepository.findById(reviewDto.getCarId()).orElseThrow(
                            () -> new CarNotFoundException(reviewDto.getCarId()));
                    review.setCar(car);
                    review.setDateTimeStamp(reviewDto.getDateTimeStamp());
                    review.setReviewText(reviewDto.getReviewText());
                    return repository.save(review);
                })
                .orElseGet(() -> {
                    Review newReview = new Review();
                    newReview.setId(id);
                    User user = userRepository.findById(reviewDto.getUserId()).orElseThrow(
                            () -> new UserNotFoundException(reviewDto.getUserId()));
                    newReview.setUser(user);
                    Car car = carRepository.findById(reviewDto.getCarId()).orElseThrow(
                            () -> new CarNotFoundException(reviewDto.getCarId()));
                    newReview.setCar(car);
                    return repository.save(newReview);
                });
    }

    @GetMapping("/reviews/search/{id}")
    List<Review> searchReview(@PathVariable("postId") String postId) {
        return repository.searchReview(postId);
    }

    @DeleteMapping("/reviews/{id}")
    void deleteReview(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }
}
