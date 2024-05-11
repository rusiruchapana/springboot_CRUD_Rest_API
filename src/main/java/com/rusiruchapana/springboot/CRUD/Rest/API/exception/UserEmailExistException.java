package com.rusiruchapana.springboot.CRUD.Rest.API.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class UserEmailExistException extends RuntimeException {
    private String message;
    public UserEmailExistException(String message){
        super(message);
    }




}
