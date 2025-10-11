package com.mecaps.socialApp.controller;

import com.mecaps.socialApp.entity.User;
import com.mecaps.socialApp.request.UserRequest;
import com.mecaps.socialApp.response.UserResponse;
import com.mecaps.socialApp.service.UserService;
import com.mecaps.socialApp.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Lombok library
//@Getter / @Setter
//@NoArgsConstructor, @AllArgsConstructor,
// @RequiredArgsConstructor(final, @NonNull)

//@Data
//A shortcut for:
//@Getter, @Setter, @ToString, @EqualsAndHashCode, and
// @RequiredArgsConstructor.

//@Builder
//Creates a Builder Pattern implementation for object creation.


@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;


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
    public ResponseEntity<?> createUser(@RequestBody User user){
        userService.createUser(user);
        return ResponseEntity.ok("User created successfully");
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
