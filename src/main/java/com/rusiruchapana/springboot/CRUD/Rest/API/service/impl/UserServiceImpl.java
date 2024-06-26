package com.rusiruchapana.springboot.CRUD.Rest.API.service.impl;

import com.rusiruchapana.springboot.CRUD.Rest.API.dto.UserDto;
import com.rusiruchapana.springboot.CRUD.Rest.API.entity.User;
import com.rusiruchapana.springboot.CRUD.Rest.API.exception.ResourceNotFoundException;
import com.rusiruchapana.springboot.CRUD.Rest.API.exception.UserEmailExistException;
import com.rusiruchapana.springboot.CRUD.Rest.API.mapper.UserMapper;
import com.rusiruchapana.springboot.CRUD.Rest.API.repository.UserRepository;
import com.rusiruchapana.springboot.CRUD.Rest.API.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

//    @Override
//    public User createUser(User user) {
//        return userRepository.save(user);
//    }

    @Override
    public UserDto createUser(UserDto userDto) {
        if(userRepository.findByEmail(userDto.getEmail()).isPresent()){
            throw new UserEmailExistException("User email is already exist.");
        }

        User user = UserMapper.mapToUser(userDto);
        userRepository.save(user);
        //UserDto userDto1 = UserMapper.mapToUserDto(user);
        UserDto userDto1 = modelMapper.map(user , UserDto.class);
        return userDto1;
    }


//    @Override
//    public User findById(Long userId) {
//        Optional<User> optionalUser = userRepository.findById(userId);
//        return optionalUser.get();
//    }

    public UserDto findById(Long userId){
        User user = userRepository.findById(userId).orElseThrow(
                ()-> new ResourceNotFoundException("User", "Id", userId)
        );

        //return UserMapper.mapToUserDto(user);
        return modelMapper.map(user , UserDto.class);
    }

    @Override
    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user) -> modelMapper.map(users , UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserDto update(UserDto userDto) {
        User existingUser =  userRepository.findById(userDto.getId()).orElseThrow(
                ()-> new ResourceNotFoundException("User", "Id", userDto.getId())
        );
        existingUser.setFirstName(userDto.getFirstName());
        existingUser.setLastName(userDto.getLastName());
        existingUser.setEmail(userDto.getEmail());
        User updatedUser = userRepository.save(existingUser);

        //return UserMapper.mapToUserDto(updatedUser);
        return modelMapper.map(updatedUser , UserDto.class);
    }

    @Override
    public void delete(Long userId) {
        User existingUser =  userRepository.findById(userId).orElseThrow(
                ()-> new ResourceNotFoundException("User", "Id", userId)
        );

        userRepository.deleteById(userId);
    }
}
