package com.mecaps.socialApp.service;

import com.mecaps.socialApp.entity.User;
import com.mecaps.socialApp.repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@ActiveProfiles("test")
public class UserTest {
    @Autowired
    private UserRepository userRepository;


    @Test
    public void findById(){

        Optional<User> byId = userRepository.findById(1l);
        assertEquals("exampleUser",
                byId.get().getUserName());

        assertEquals("example@email.com",
                byId.get().getEmail());

        assertNotNull(byId.get().getUserName());
    }

    @Disabled
    @Test
    public void assertNullAndNot(){
        String name = null;
        String name1 = "md";
//        assertNotNull(name);
        assertNull(name);
    }

    @Test
    public void assertIterble(){

        List<String> target = List.of("A","B","C","D");
        List<String> actual = List.of("A","B", "C", "D");

        assertIterableEquals(target,actual);
    }

    @Test
    public void assertSameAndNot(){
        String obj1 = "Md";
        String obj2 = obj1;
        String obj3 = new String(obj1);


//        assertSame(obj1, obj2);
        assertNotSame(obj1, obj3);
    }


    @Test
    public void arrayEquals(){
        int[] arr = {1,2,3};
        int[] arr1 = {1,2,3, 4};

        assertArrayEquals(arr1, arr);
    }


}
