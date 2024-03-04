package com.example.Schoolwebsitebackend.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Schoolwebsitebackend.Model.Role;

public interface RoleRepo extends JpaRepository<Role,String>{

    Optional<Role> findByAuthority(String authority);
}
