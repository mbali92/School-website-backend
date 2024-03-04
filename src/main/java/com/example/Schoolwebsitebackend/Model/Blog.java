package com.example.Schoolwebsitebackend.Model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }

    public String getPostTags() {
        return postTags;
    }

    public void setPostTags(String postTags) {
        this.postTags = postTags;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    private String postTitle;

    @Column(columnDefinition = "TEXT")
    private String postBody;

    private String postTags;

    @Lob
    @Column(length = 10485760)
    private byte[] file; // Byte array to store the image data

    // Getters and setters (omitted for brevity)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
