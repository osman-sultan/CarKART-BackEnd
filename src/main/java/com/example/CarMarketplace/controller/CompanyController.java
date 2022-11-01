package com.example.CarMarketplace.controller;

import com.example.CarMarketplace.controller.exceptions.CompanyNotFoundException;
import com.example.CarMarketplace.model.entity.Company;
import com.example.CarMarketplace.model.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class CompanyController {

    @Autowired
    private final CompanyRepository repository;

    public CompanyController(CompanyRepository repository){
        this.repository = repository;
    }

    @GetMapping("/company")
    List<Company> retrieveAllCompanies(){
        return repository.findAll();
    }

    @GetMapping("/company/{make}")
    Company retrieveCompany(@PathVariable("make") String make){
        return repository.findById(make).orElseThrow(
                () -> new CompanyNotFoundException(make)
        );
    }

    @PostMapping("/company")
    Company createCompany(@RequestBody Company newCompany) {
        return repository.save(newCompany);
    }

    @DeleteMapping("/company/{make}")
    void deleteCompany(@PathVariable("make") String make) {
        repository.deleteById(make);
    }

}
