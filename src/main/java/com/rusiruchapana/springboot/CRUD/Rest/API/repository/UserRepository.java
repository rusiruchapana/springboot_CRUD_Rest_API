package com.rusiruchapana.springboot.CRUD.Rest.API.repository;

import com.rusiruchapana.springboot.CRUD.Rest.API.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}