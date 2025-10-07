package com.mecaps.socialApp.request;


import lombok.Data;

@Data
public class CommentRequest {

    private String commentString;
    private Long postId;
    private Long userId;

}
