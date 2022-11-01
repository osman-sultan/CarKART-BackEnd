package com.example.CarMarketplace.controller;

import com.example.CarMarketplace.controller.dto.UserDto;
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

    @GetMapping("/users")
    List<User> retrieveAllUsers(){
        return repository.findAll();
    }

    @GetMapping("/users/{id}")
    User retrieveUser(@PathVariable("id") Long id){
        return repository.findById(id).orElseThrow(
                () -> new UserNotFoundException(id)
        );
    }

    @PostMapping("/users")
    User createUser(@RequestBody UserDto userDto) {
        User newUser = new User();
        newUser.setId(userDto.getId());
        newUser.setUsername(userDto.getUsername());
        newUser.setFirstName(userDto.getFirstName());
        newUser.setLastName(userDto.getLastName());
        newUser.setEmail(userDto.getEmail());
        newUser.setPassword(userDto.getPassword());
        newUser.setAddress(userDto.getAddress());
        return repository.save(newUser);
    }

    @PutMapping("/users/{id}")
    User updateUsers(@RequestBody UserDto userDto, @PathVariable("id") Long userId) {
        return repository.findById(userId)
                .map(user -> {
                    user.setId(userDto.getId());
                    user.setUsername(userDto.getUsername());
                    user.setFirstName(userDto.getFirstName());
                    user.setLastName(userDto.getLastName());
                    user.setEmail(userDto.getEmail());
                    user.setPassword(userDto.getPassword());
                    user.setAddress(userDto.getAddress());
                    return repository.save(user);
                })
                .orElseGet(() -> {
                    User newUser = new User();
                    newUser.setId(userId);
                    return repository.save(newUser);
                });
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }

}
