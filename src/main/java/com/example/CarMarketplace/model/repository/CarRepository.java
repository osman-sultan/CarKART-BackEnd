package com.example.CarMarketplace.model.repository;

import com.example.CarMarketplace.model.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository <Car, Integer>{
}

