package com.example.Schoolwebsitebackend.Filter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.Schoolwebsitebackend.Model.User;
import com.example.Schoolwebsitebackend.Service.UserService;

import jakarta.annotation.PostConstruct;
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user")
public class UserController {

     @Autowired
    private UserService usersService;

    @PostConstruct
    private void assignRoleTable(){
        usersService.assignRoleTable();
    }


    @PostMapping("/registration")
    public User registerNewUser(
            @RequestParam("userName") String userName,
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("userPassword") String password,
            @RequestParam("photo") MultipartFile photo
    )throws Exception{

            System.out.println("Received parameters: " + userName + ", " + firstName + ", " + lastName + ", " + password);

            return usersService.RegisterUser(userName, firstName, lastName, password, photo);

    }

    @GetMapping("/allUsers")
    private List<User> findAllUsers(){
        return usersService.getAllUsers();
    }

    @GetMapping("/pagination/{offset}/{pageSize}")
    public Page<User> findCandidateByPagination(@PathVariable Integer offset, @PathVariable Integer pageSize)throws UsernameNotFoundException {
        return usersService.findUserByPagination(offset,pageSize);}


    @GetMapping("/findByUsername/{userName}")
    private User findUser(@PathVariable String userName){
        return usersService.findUserByUserName(userName);
    }


    @DeleteMapping("/deleteUser/{userName}")
    public void deleteUser(@PathVariable String userName){
        usersService.deleteUser(userName);

    }

    @PutMapping("/updateUser/{username}")
    public User updateUser(@PathVariable String username,@RequestBody User user) {
        return usersService.update(username,user);
    }

    @PostMapping("/forAdmin")
    private String forAdmin(){
        return "welcome Admin";
    }

    @PostMapping("/forUser")
    private String forUser(){
        return "welcome user";
    }

    @GetMapping("/count")
    private Long count(){return usersService.userCount();}
    
}