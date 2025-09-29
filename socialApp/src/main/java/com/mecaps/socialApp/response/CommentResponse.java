package com.mecaps.socialApp.response;

import com.mecaps.socialApp.entity.Comment;
import org.springframework.stereotype.Component;


public class CommentResponse {

    private String commentedString;
    private PostResponse postResponse;

    public CommentResponse(Comment comment) {

        this.commentedString = comment.getCommentString();
        this.postResponse = new PostResponse(comment.getPostId());
    }

    public String getCommentedString() {
        return commentedString;
    }

    public void setCommentedString(String commentedString) {
        this.commentedString = commentedString;
    }

    public PostResponse getPostResponse() {
        return postResponse;
    }

    public void setPostResponse(PostResponse postResponse) {
        this.postResponse = postResponse;
    }
}
