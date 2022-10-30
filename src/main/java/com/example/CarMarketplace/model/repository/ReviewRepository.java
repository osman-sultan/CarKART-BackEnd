package com.example.CarMarketplace.model.repository;

import com.example.CarMarketplace.model.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository <Review, Integer>{
}
