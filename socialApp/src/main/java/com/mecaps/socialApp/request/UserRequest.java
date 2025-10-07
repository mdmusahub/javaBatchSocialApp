package com.mecaps.socialApp.request;


import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Data
public class UserRequest {
    private String userName;
    private String password;
    private String email;
}
