package com.example.Schoolwebsitebackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Schoolwebsitebackend.Model.Blog;

public interface BlogRepo extends JpaRepository<Blog, Integer> {
}
