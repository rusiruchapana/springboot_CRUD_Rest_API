package com.rusiruchapana.springboot.CRUD.Rest.API.controller;

import com.rusiruchapana.springboot.CRUD.Rest.API.entity.User;
import com.rusiruchapana.springboot.CRUD.Rest.API.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class userContoller {

    private UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedData = userService.createUser(user);
        return new ResponseEntity<>(savedData , HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> findById(@PathVariable("id") Long userId){
        User user = userService.findById(userId);
        return  new ResponseEntity<>(user , HttpStatus.OK);
    }





}
