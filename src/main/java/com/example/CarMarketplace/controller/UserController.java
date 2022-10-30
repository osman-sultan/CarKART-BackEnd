package com.example.CarMarketplace.controller;

import com.example.CarMarketplace.controller.exceptions.UserNotFoundException;
import com.example.CarMarketplace.model.entity.User;
import com.example.CarMarketplace.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private final UserRepository repository;

    public UserController(UserRepository repository){
        this.repository = repository;
    }

    @GetMapping("/user")
    List<User> retrieveAllUsers(){
        return repository.findAll();
    }

    @GetMapping("/user/{id}")
    User retrieveUser(@PathVariable("id") int id){
        return repository.findById(id).orElseThrow(
                () -> new UserNotFoundException(id)
        );
    }

    @PostMapping("/user")
    User createUSer(@RequestBody User newUser) {
        return repository.save(newUser);
    }

}
