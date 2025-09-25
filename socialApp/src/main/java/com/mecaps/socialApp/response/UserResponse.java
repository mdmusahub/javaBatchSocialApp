package com.mecaps.socialApp.response;
import com.mecaps.socialApp.entity.User;

public class UserResponse {
    private Long id;
    private String userName ;
    private String email;

    public UserResponse(User user) {
        this.id = user.getId();
        this.userName = user.getUserName();
        this.email = user.getEmail();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
