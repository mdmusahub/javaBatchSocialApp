package com.mecaps.socialApp.controller;

import com.mecaps.socialApp.entity.User;
import com.mecaps.socialApp.request.UserRequest;
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

    @PutMapping("/update")
    public UserResponse updateUser(@PathVariable Long id,
                                   @RequestBody UserRequest userRequest){

        return userService.updateUser(id, userRequest);
    }


    @DeleteMapping("/delete/{id}")
    public String deleteUserById(@PathVariable Long id){
        return userService.deleteUserById(id);
    }


}
