package com.example.CarMarketplace.model.repository;

import com.example.CarMarketplace.model.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface CarRepository extends JpaRepository <Car, Integer>{

    @Query(value = "select * from Car_E c " +
            "where lower(c.model) like lower(concat('%', :modelName, '%'))", nativeQuery = true)
    List<Car> searchModel(@Param("modelName") String modelName);
}

