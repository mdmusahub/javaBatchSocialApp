package com.mecaps.socialApp.service;


import com.mecaps.socialApp.entity.User;
import com.mecaps.socialApp.repository.UserRepository;
import com.mecaps.socialApp.serviceImpl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ServiceMockitoTest {

//    @Autowired
//    private UserRepository userRepository;

    @Mock
    private UserRepository userRepository;
//    @Autowired
//    private UserService userService;
    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void testFindByEmail(){
        String email = "md@gmail.com";
        User userMock = new User();
        userMock.setId(1L);
        userMock.setUserName("Malik");
        userMock.setEmail(email);
        userMock.setPassword("abc");

        when(userRepository.findByEmail(email)).thenReturn(Optional.of(userMock));
        User byUserEmail = userService.findByUserEmail(email);
        assertNotNull(byUserEmail);
        assertEquals("Malik",byUserEmail.getUserName());
        assertEquals("abc", byUserEmail.getPassword());
//        assertNull(byUserEmail);



    }
}
