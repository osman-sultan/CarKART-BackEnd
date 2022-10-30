package com.example.CarMarketplace.model.repository;

import com.example.CarMarketplace.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Integer>{
}
