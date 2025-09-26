package com.mecaps.socialApp.controller;

import com.mecaps.socialApp.entity.User;
import com.mecaps.socialApp.response.UserResponse;
import com.mecaps.socialApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get")
    public List<UserResponse> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping("/by-email")
    public User findByUserEmail(@RequestParam String email){
        return userService.findByUserEmail(email);
    }

    @PostMapping("/create")
    public void createUser(@RequestBody User user){
        userService.createUser(user);
    }
}
