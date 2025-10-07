package com.mecaps.socialApp.response;
import com.mecaps.socialApp.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
    private Long id;
    private String userName ;
    private String email;

    public UserResponse(User user) {
        this.id = user.getId();
        this.userName = user.getUserName();
        this.email = user.getEmail();
    }

}
