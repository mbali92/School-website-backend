package com.example.Schoolwebsitebackend.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.example.Schoolwebsitebackend.Repository.BlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.Schoolwebsitebackend.Model.Blog;

@Service
public class BlogService {

    @Autowired
    private BlogRepo BlogRepo;

    public Blog createBlog(MultipartFile file, String postTitle, String postBody, String postTags) throws IOException {
        Blog blog = new Blog();
        blog.setPostTitle(postTitle);
        blog.setPostBody(postBody);
        blog.setPostTags(postTags);
        blog.setFile(file.getBytes()); // Set the picture bytes from the uploaded file

        return BlogRepo.save(blog);
    }

    public List<Blog> getAll() {
        return BlogRepo.findAll();
    }

    public Blog updateBlog(int id, MultipartFile file, String postTitle, String postBody, String postTags)
            throws IOException {
        Blog findBlog = BlogRepo.findById(id).orElse(null);
        if (findBlog != null) {
            findBlog.setPostTitle(postTitle);
            findBlog.setPostBody(postBody);
            findBlog.setPostTags(postTags);
            if (file != null && !file.isEmpty()) {
                findBlog.setFile(file.getBytes()); // Update the picture bytes from the uploaded file
            }
            return BlogRepo.save(findBlog);
        } else {
            throw new IllegalArgumentException("Blog with id " + id + " not found");
        }
    }

    public void deleteBlog(int id) {
        BlogRepo.deleteById(id);
    }

    public byte[] getImageById(Integer id) {
        Optional<Blog> optionalBlog = BlogRepo.findById(id);
        if (optionalBlog.isPresent()) {
            Blog blog = optionalBlog.get();
            return blog.getFile();
        } else {
            throw new IllegalArgumentException("Image with id " + id + " not found");
        }
    }

}
