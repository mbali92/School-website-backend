package com.example.Schoolwebsitebackend.Service;

import com.example.Schoolwebsitebackend.Model.AuthenticationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler;
import org.springframework.stereotype.Service;

import com.example.Schoolwebsitebackend.Model.User;
import com.example.Schoolwebsitebackend.Repository.UserRepo;

@Service
public class AuthenticationService {


    @Autowired
    private UserRepo userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;


    public String authenticate(AuthenticationRequest request){
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUserName(), request.getUserPassword()
        ));
        if(authenticate.isAuthenticated()){
            User user = userRepository.findByUserName(request.getUserName()).orElseThrow();
            System.out.println(jwtService.generateToken(user));
            return jwtService.generateToken(user);
        }else {
            throw new UsernameNotFoundException("invalid user");
        }

    }

    
}
