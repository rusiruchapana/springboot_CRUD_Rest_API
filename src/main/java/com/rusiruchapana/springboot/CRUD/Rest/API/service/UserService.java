package com.rusiruchapana.springboot.CRUD.Rest.API.service;

import com.rusiruchapana.springboot.CRUD.Rest.API.dto.UserDto;
import com.rusiruchapana.springboot.CRUD.Rest.API.entity.User;

import java.util.List;

public interface UserService {
    //User createUser(User user);
    UserDto createUser(UserDto userDto);









    User findById(Long userId);

    List<User> findAll();

    User update(User user);

    void delete(Long userId);
}
