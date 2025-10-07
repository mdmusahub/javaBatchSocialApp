package com.mecaps.socialApp.service;
import com.mecaps.socialApp.entity.User;
import com.mecaps.socialApp.response.UserResponse;
import com.mecaps.socialApp.request.UserRequest;
import java.util.List;

public interface UserService {

    void createUser(User userRequest);

    List<UserResponse> getAllUser();

    User findByUserEmail(String email);

    UserResponse updateUser(Long id, UserRequest userRequest);

    String deleteUserById(Long id);
}
