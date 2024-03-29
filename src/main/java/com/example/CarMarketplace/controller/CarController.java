package com.example.CarMarketplace.controller;

import com.example.CarMarketplace.controller.dto.CarDto;
import com.example.CarMarketplace.controller.exceptions.CarNotFoundException;
import com.example.CarMarketplace.controller.exceptions.CompanyNotFoundException;
import com.example.CarMarketplace.controller.exceptions.UserNotFoundException;
import com.example.CarMarketplace.model.entity.Car;
import com.example.CarMarketplace.model.entity.Company;
import com.example.CarMarketplace.model.entity.Review;
import com.example.CarMarketplace.model.entity.User;
import com.example.CarMarketplace.model.repository.CarRepository;
import com.example.CarMarketplace.model.repository.CompanyRepository;
import com.example.CarMarketplace.model.repository.ReviewRepository;
import com.example.CarMarketplace.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class CarController {

    @Autowired
    private final CarRepository repository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;

    public CarController(CarRepository repository){
        this.repository = repository;
    }

    @GetMapping("/cars")
    List<Car> retrieveAllCars(){
        return repository.findAll();
    }

    @GetMapping("/cars/{id}")
    Car retrieveCar(@PathVariable("id") Long id){
        return repository.findById(id).orElseThrow(
                () -> new CarNotFoundException(id)
        );
    }

    @PostMapping("/cars")
    Car createCar(@RequestBody CarDto carDto) {
        Car newCar = new Car();
        newCar.setId(carDto.getId());
        newCar.setModel(carDto.getModel());
        newCar.setReleaseYear(carDto.getReleaseYear());
        newCar.setFuelType(carDto.getFuelType());
        newCar.setPrice(carDto.getPrice());
        newCar.setVehicleType(carDto.getVehicleType());
        newCar.setHp(carDto.getHp());
        newCar.setMileage(carDto.getMileage());
        newCar.setColour(carDto.getColour());
        newCar.setTransmission(carDto.getTransmission());
        newCar.setCarURL(carDto.getCarURL());
        Company company = companyRepository.findById(carDto.getMake()).orElseThrow(
                () -> new CompanyNotFoundException(carDto.getMake()));
        newCar.setCompany(company);
        User seller = userRepository.findById(carDto.getSellerId()).orElseThrow(
                () -> new UserNotFoundException(carDto.getSellerId()));
        newCar.setSeller(seller);
        return repository.save(newCar);


    }

    @PutMapping("/cars/{id}")
    Car updateCars(@RequestBody CarDto carDto, @PathVariable("id") Long id_of_car) {
        return repository.findById(id_of_car)
                .map(car -> {
                    Company company = companyRepository.findById(carDto.getMake()).orElseThrow(
                            () -> new CompanyNotFoundException(carDto.getMake()));
                    car.setCompany(company);
                    User seller = userRepository.findById(carDto.getSellerId()).orElseThrow(
                            () -> new UserNotFoundException(carDto.getSellerId()));
                    car.setSeller(seller);
                    car.setModel(carDto.getModel());
                    car.setReleaseYear(carDto.getReleaseYear());
                    car.setFuelType(carDto.getFuelType());
                    car.setPrice(carDto.getPrice());
                    car.setVehicleType(carDto.getVehicleType());
                    car.setHp(carDto.getHp());
                    car.setMileage(carDto.getMileage());
                    car.setColour(carDto.getColour());
                    car.setTransmission(carDto.getTransmission());
                    car.setCarURL((carDto.getCarURL()));
                    return repository.save(car);
                })
                .orElseGet(() -> {
                    Car newCar = new Car();
                    newCar.setId(id_of_car);
                    Company company = companyRepository.findById(carDto.getMake()).orElseThrow(
                            () -> new CompanyNotFoundException(carDto.getMake()));
                    newCar.setCompany(company);
                    User seller = userRepository.findById(carDto.getSellerId()).orElseThrow(
                            () -> new UserNotFoundException(carDto.getSellerId()));
                    newCar.setSeller(seller);
                    return repository.save(newCar);
                });
    }

    @GetMapping("/cars/search/model/{keyWord}")
    List<Car> searchCarModel(@PathVariable("keyWord") String keyWord) {
        return repository.searchModel(keyWord);
    }

    @DeleteMapping("/cars/{id}")
    void deleteCar(@PathVariable("id") Long id) {
        List<Review> associatedReviews = reviewRepository.searchReviewOnCar(id);

        for(Review review: associatedReviews) {
            reviewRepository.delete(review);
        }
        repository.deleteById(id);
    }
}
