package com.mecaps.socialApp.response;

import com.mecaps.socialApp.entity.Post;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;

@Getter
@Setter
public class PostResponse {
    private String content;
    private String postedAt;
    private UserResponse userName;

    public PostResponse(Post post) {
        this.content = post.getContent();
        this.postedAt = post.getPostedAt();
        this.userName = new UserResponse(post.getAuthor());
    }

}
