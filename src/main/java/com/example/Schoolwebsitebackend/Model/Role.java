package com.example.Schoolwebsitebackend.Model;

import jakarta.persistence.Entity;
import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Id;
@Entity
public class Role implements GrantedAuthority {
    @Id
    private String authority;

    public Role(String authority) {
        this.authority = authority;
    }

    public Role() {
    }



    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
