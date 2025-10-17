package com.mecaps.socialApp.controller;

import com.mecaps.socialApp.entity.User;
import com.mecaps.socialApp.request.LoginDTO;
import com.mecaps.socialApp.request.UserRequest;
import com.mecaps.socialApp.response.UserResponse;
import com.mecaps.socialApp.security.JwtService;
import com.mecaps.socialApp.service.UserService;
import com.mecaps.socialApp.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private final JwtService jwtService;


    public UserController(UserService userService, JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }


    @PostMapping("/create")
    public Map<String , String> login(@RequestBody LoginDTO request){
        String token = jwtService
                .generateAccessToken(request.getEmail(), request.getRole());
        Map<String, String> map = new HashMap<>();
        map.put("Access Token : ", token);
        map.put("Role : ", request.getRole());
        return map;
    }


    @GetMapping("/get/all")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping("/findByUserName")
    public List<User> getUserByNameUsingCriteria(@RequestParam String userName){
        return userService.getUserByNameUsingCriteriaAPI(userName);
    }

    @GetMapping("/by-email")
    public User findByUserEmail(@RequestParam String email){
        return userService.findByUserEmail(email);
    }


//    @PostMapping("/create")
//    public ResponseEntity<?> createUser(@RequestBody User user){
//        userService.createUser(user);
//        return ResponseEntity.ok("User created successfully");
//    }

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
