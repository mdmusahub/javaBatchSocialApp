package com.mecaps.socialApp.service;

import com.mecaps.socialApp.entity.User;
import com.mecaps.socialApp.repository.UserRepository;
import com.mecaps.socialApp.request.UserRequest;
import com.mecaps.socialApp.response.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public ResponseEntity<?> createUser(User userRequest) {
        User userObj = new User();
        userObj.setUserName(userRequest.getUserName());
        userObj.setEmail(userRequest.getEmail());
        userObj.setPassword(userRequest.getPassword());
        User save = userRepository.save(userRequest);
        

//        return ResponseEntity.ok("User Created");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of(
                        "message" , "User Created successfully",
                        "body" , save,
                        "success", true
                ));


    }


    public List<UserResponse> getAllUser() {
        List<User> userList = userRepository.findAll();

//        List<UserResponse> userResponseArrayList = new ArrayList<>();
//        for (User user : userList){
//            UserResponse userResponse = new UserResponse(user);
//            userResponseArrayList.add(userResponse);
//        }
//        return userResponseArrayList;

        return userList.stream().map(UserResponse::new).toList();

    }


    public User findByUserEmail(String email){

        User user = userRepository.findByEmail(email)
                .orElseThrow( () -> new RuntimeException("User not found"));
        return user;
    }

    public UserResponse updateUser(Long id, UserRequest userRequest) {

        User user = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("user not found")
        );

        user.setUserName(userRequest.getUserName());
        user.setPassword(userRequest.getPassword());
        user.setEmail(userRequest.getEmail());
        User save = userRepository.save(user);
        return new UserResponse(save);

    }



    public String deleteUserById(Long id){

        User user = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("user not found")
        );
        userRepository.delete(user);
        return "User Delete Successfully!";

    }
}
