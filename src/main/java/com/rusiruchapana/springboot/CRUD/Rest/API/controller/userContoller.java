package com.rusiruchapana.springboot.CRUD.Rest.API.controller;

import com.rusiruchapana.springboot.CRUD.Rest.API.dto.UserDto;
import com.rusiruchapana.springboot.CRUD.Rest.API.entity.User;
import com.rusiruchapana.springboot.CRUD.Rest.API.exception.ErrorDetails;
import com.rusiruchapana.springboot.CRUD.Rest.API.exception.ResourceNotFoundException;
import com.rusiruchapana.springboot.CRUD.Rest.API.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
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
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
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
    public ResponseEntity<List<UserDto>> findAll(){
        List<UserDto> users = userService.findAll();
        return new ResponseEntity<>(users , HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserDto> update(@PathVariable("id") Long userId , @Valid @RequestBody UserDto userDto){
        userDto.setId(userId);
        UserDto userDto1 = userService.update(userDto);
        return new ResponseEntity<>(userDto1 , HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long userId){

        userService.delete(userId);
        return ResponseEntity.ok("Succesfully deleted");
    }

//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorDetails> handleResourcesNotFoundException(ResourceNotFoundException exception , WebRequest webRequest){
//        ErrorDetails errorDetails = new ErrorDetails(
//                LocalDateTime.now(),
//                exception.getMessage(),
//                webRequest.getDescription(false),
//                "User_Not_Found"
//        );
//
//        return new ResponseEntity<>(errorDetails , HttpStatus.NOT_FOUND);
//    }




}
