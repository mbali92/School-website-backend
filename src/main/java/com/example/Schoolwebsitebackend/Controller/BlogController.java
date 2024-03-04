package com.example.Schoolwebsitebackend.Controller;

import com.example.Schoolwebsitebackend.Model.Blog;
import com.example.Schoolwebsitebackend.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public class BlogController {
    private final BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping("/saveBlog")
    public Blog createBlog(@RequestParam("file") MultipartFile file, @RequestParam("postTitle") String postTitle, @RequestParam("postBody") String postBody, @RequestParam("postTags") String postTags) throws IOException {
        return blogService.createBlog(file, postTitle, postBody, postTags);
    }

    @GetMapping("/allBlogs")
    public List<Blog> getAllBlogs(){
        return blogService.getAll();
    }

    @PutMapping("/editBlog/{id}")
    public Blog editBlog(@PathVariable int id, @RequestParam("file") MultipartFile file, @RequestParam("postTitle") String postTitle, @RequestParam("postBody") String postBody, @RequestParam("postTags") String postTags) throws IOException {
        return blogService.updateBlog(id, file, postTitle, postBody, postTags);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id){
        blogService.deleteBlog(id);
    }

    @GetMapping("/getImage/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Integer id) {
        byte[] imageData = blogService.getImageById(id);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageData);
    }
}
