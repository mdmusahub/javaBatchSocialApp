package com.mecaps.socialApp.serviceImpl;

import com.mecaps.socialApp.entity.User;
import com.mecaps.socialApp.repository.UserRepository;
import com.mecaps.socialApp.request.UserRequest;
import com.mecaps.socialApp.response.UserResponse;
import com.mecaps.socialApp.service.UserService;
import org.springframework.stereotype.Service;
import com.mecaps.socialApp.exception.UserNotFoundException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void createUser(User userRequest) {
        User userObj = new User();
        userObj.setUserName(userRequest.getUserName());
        userObj.setEmail(userRequest.getEmail());
        userObj.setPassword(userRequest.getPassword());
        userRepository.save(userRequest);
        

//        return ResponseEntity.ok("User Created");
//        return ResponseEntity
//                .status(HttpStatus.CREATED)
//                .body(Map.of(
//                        "message" , "User Created successfully",
//                        "body" , save,
//                        "success", true
//                ));


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
                .orElseThrow( () -> new UserNotFoundException("User not found by " + email+ " email"));
        return user;
    }

    @Override
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
