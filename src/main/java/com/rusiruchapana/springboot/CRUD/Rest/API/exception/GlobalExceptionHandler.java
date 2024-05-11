package com.rusiruchapana.springboot.CRUD.Rest.API.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourcesNotFoundException(ResourceNotFoundException exception , WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "User_Not_Found"
        );

        return new ResponseEntity<>(errorDetails , HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserEmailExistException.class)
    public ResponseEntity<ErrorDetails> handleUserEmailExistException(ResourceNotFoundException exception , WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "User_Email_is_Exist"
        );

        return new ResponseEntity<>(errorDetails , HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleException(ResourceNotFoundException exception , WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "Internal_error"
        );

        return new ResponseEntity<>(errorDetails , HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
