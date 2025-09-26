package com.mecaps.socialApp.service;

import com.mecaps.socialApp.entity.User;
import com.mecaps.socialApp.repository.UserRepository;
import com.mecaps.socialApp.response.UserResponse;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void createUser(User userRequest) {
        User userObj = new User();
        userObj.setUserName(userRequest.getUserName());
        userObj.setEmail(userRequest.getEmail());
        userObj.setPassword(userRequest.getPassword());
        userRepository.save(userRequest);

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
}
