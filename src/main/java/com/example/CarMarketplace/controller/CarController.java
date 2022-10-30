package com.example.CarMarketplace.controller;

import com.example.CarMarketplace.controller.dto.CarDto;
import com.example.CarMarketplace.controller.exceptions.CarNotFoundException;
import com.example.CarMarketplace.controller.exceptions.CompanyNotFoundException;
import com.example.CarMarketplace.model.entity.Car;
import com.example.CarMarketplace.model.entity.Company;
import com.example.CarMarketplace.model.repository.CarRepository;
import com.example.CarMarketplace.model.repository.CompanyRepository;
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

    public CarController(CarRepository repository){
        this.repository = repository;
    }

    @GetMapping("/cars")
    List<Car> retrieveAllCars(){
        return repository.findAll();
    }

    @GetMapping("/cars/{id}")
    Car retrieveCar(@PathVariable("id") int id){
        return repository.findById(id).orElseThrow(
                () -> new CarNotFoundException(id)
        );
    }

    @PostMapping("/courses")
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
        Company company = companyRepository.findById(carDto.getMake()).orElseThrow(
                () -> new CompanyNotFoundException(carDto.getMake()));
        newCar.setCompany(company);
        return repository.save(newCar);
    }
}
