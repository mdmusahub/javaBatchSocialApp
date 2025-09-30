package com.mecaps.socialApp.response;

import com.mecaps.socialApp.entity.Post;
import org.apache.catalina.User;

public class PostResponse {
    private String content;
    private String postedAt;
    private UserResponse userName;

    public PostResponse(Post post) {
        this.content = post.getContent();
        this.postedAt = post.getPostedAt();
        this.userName = new UserResponse(post.getAuthor());
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(String postedAt) {
        this.postedAt = postedAt;
    }

    public UserResponse getUserName() {
        return userName;
    }

    public void setUserName(UserResponse userName) {
        this.userName = userName;
    }
}
