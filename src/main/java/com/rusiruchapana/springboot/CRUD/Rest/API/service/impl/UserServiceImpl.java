package com.rusiruchapana.springboot.CRUD.Rest.API.service.impl;

import com.rusiruchapana.springboot.CRUD.Rest.API.dto.UserDto;
import com.rusiruchapana.springboot.CRUD.Rest.API.entity.User;
import com.rusiruchapana.springboot.CRUD.Rest.API.mapper.UserMapper;
import com.rusiruchapana.springboot.CRUD.Rest.API.repository.UserRepository;
import com.rusiruchapana.springboot.CRUD.Rest.API.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

//    @Override
//    public User createUser(User user) {
//        return userRepository.save(user);
//    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);
        userRepository.save(user);
        UserDto userDto1 = UserMapper.mapToUserDto(user);
        return userDto1;
    }
    

    @Override
    public User findById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.get();
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User update(User user) {
        User existingUser =  userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(existingUser);

        return updatedUser;
    }

    @Override
    public void delete(Long userId) {
        userRepository.deleteById(userId);
    }
}
