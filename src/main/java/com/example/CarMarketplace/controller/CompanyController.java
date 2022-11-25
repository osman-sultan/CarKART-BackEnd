package com.example.CarMarketplace.controller;

import com.example.CarMarketplace.controller.dto.CompanyDto;
import com.example.CarMarketplace.controller.dto.ReviewDto;
import com.example.CarMarketplace.controller.exceptions.CarNotFoundException;
import com.example.CarMarketplace.controller.exceptions.CompanyNotFoundException;
import com.example.CarMarketplace.controller.exceptions.UserNotFoundException;
import com.example.CarMarketplace.model.entity.Car;
import com.example.CarMarketplace.model.entity.Company;
import com.example.CarMarketplace.model.entity.Review;
import com.example.CarMarketplace.model.entity.User;
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

    @PutMapping("/company/{make}")
    Company updateCompany(@RequestBody CompanyDto companyDto, @PathVariable("make") String make) {
        return repository.findById(make)
                .map(company -> {
                    company.setCountry(companyDto.getCountry());
                    company.setYearFounded(companyDto.getYearFounded());
                    company.setHq(companyDto.getHq());
                    company.setLogoURL(companyDto.getLogoURL());
                    return repository.save(company);
                })
                .orElseGet(() -> {
                    Company newCompany = new Company();
                    newCompany.setMake(make);
                    return repository.save(newCompany);
                });
    }

    @PostMapping("/company")
    Company createCompany(@RequestBody CompanyDto companyDto) {
        Company newCompany = new Company();

        newCompany.setMake(companyDto.getMake());
        newCompany.setCountry(companyDto.getCountry());
        newCompany.setYearFounded(companyDto.getYearFounded());
        newCompany.setHq(companyDto.getHq());
        newCompany.setLogoURL(companyDto.getLogoURL());

        return repository.save(newCompany);
    }

    @DeleteMapping("/company/{make}")
    void deleteCompany(@PathVariable("make") String make) {
        repository.deleteById(make);
    }

}
