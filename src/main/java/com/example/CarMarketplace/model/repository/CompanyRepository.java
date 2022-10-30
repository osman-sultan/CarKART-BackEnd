package com.example.CarMarketplace.model.repository;

import com.example.CarMarketplace.model.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository <Company, String>{
}
