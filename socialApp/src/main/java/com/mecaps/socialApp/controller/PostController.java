package com.mecaps.socialApp.controller;


import com.mecaps.socialApp.entity.Post;
import com.mecaps.socialApp.service.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {


    private final PostService postService;


    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/get")
    public List<Post> getAllPost(){
        return postService.getAllPost();
    }
}
