package com.rusiruchapana.springboot.CRUD.Rest.API.controller;

import com.rusiruchapana.springboot.CRUD.Rest.API.dto.UserDto;
import com.rusiruchapana.springboot.CRUD.Rest.API.entity.User;
import com.rusiruchapana.springboot.CRUD.Rest.API.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class userContoller {

    private UserService userService;

//    @PostMapping("/createUser")
//    public ResponseEntity<User> createUser(@RequestBody User user){
//        User savedData = userService.createUser(user);
//        return new ResponseEntity<>(savedData , HttpStatus.CREATED);
//    }

    @PostMapping("/createUser")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto userDto1 = userService.createUser(userDto);
        return new  ResponseEntity<>(userDto1 , HttpStatus.CREATED);
    }



//    @GetMapping("{id}")
//    public ResponseEntity<User> findById(@PathVariable("id") Long userId){
//        User user = userService.findById(userId);
//        return  new ResponseEntity<>(user , HttpStatus.OK);
//    }


    @GetMapping("/findById/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable("id") Long userId){
        UserDto userDto = userService.findById(userId);
        return new ResponseEntity<>(userDto , HttpStatus.OK);
    }




    @GetMapping("/findAll")
    public ResponseEntity<List<User>> findAll(){
        List<User> users = userService.findAll();
        return new ResponseEntity<>(users , HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> update(@PathVariable("id") Long userId , @RequestBody User user){
        user.setId(userId);
        User user1 = userService.update(user);
        return new ResponseEntity<>(user1 , HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long userId){

        userService.delete(userId);
        return ResponseEntity.ok("Succesfully deleted");
    }

}
