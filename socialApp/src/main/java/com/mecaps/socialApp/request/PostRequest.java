package com.mecaps.socialApp.request;

import lombok.Data;

@Data
public class PostRequest {
    private String content;
    private Long author;
}
