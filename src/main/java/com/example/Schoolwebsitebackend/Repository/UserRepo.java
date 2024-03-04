package com.example.Schoolwebsitebackend.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Schoolwebsitebackend.Model.User;

public interface UserRepo extends JpaRepository<User,String>{

    Optional<User> findByUserName(String userName);
    User deleteByUserName(String userName);
}
