package com.rusiruchapana.springboot.CRUD.Rest.API.service;

import com.rusiruchapana.springboot.CRUD.Rest.API.dto.UserDto;
import com.rusiruchapana.springboot.CRUD.Rest.API.entity.User;

import java.util.List;

public interface UserService {
    //User createUser(User user);
    UserDto createUser(UserDto userDto);


    //User findById(Long userId);
    UserDto findById(Long userId);





    List<UserDto> findAll();

    UserDto update(UserDto userDto);

    void delete(Long userId);
}
