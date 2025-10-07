package com.mecaps.socialApp.response;

import com.mecaps.socialApp.entity.Comment;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

//ResponseEntity<?>
// status code
//body
//massage

@Getter
@Setter
public class CommentResponse {

    private String commentedString;
    private PostResponse postResponse;

    public CommentResponse(Comment comment) {

        this.commentedString = comment.getCommentString();
        this.postResponse = new PostResponse(comment.getPostId());
    }

}
