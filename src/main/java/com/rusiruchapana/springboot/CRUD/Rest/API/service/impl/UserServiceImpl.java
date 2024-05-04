package com.rusiruchapana.springboot.CRUD.Rest.API.service.impl;

import com.rusiruchapana.springboot.CRUD.Rest.API.entity.User;
import com.rusiruchapana.springboot.CRUD.Rest.API.repository.UserRepository;
import com.rusiruchapana.springboot.CRUD.Rest.API.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.get();
    }
}