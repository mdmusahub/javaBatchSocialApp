package com.mecaps.socialApp.controller;


import com.mecaps.socialApp.entity.Post;
import com.mecaps.socialApp.request.PostRequest;
import com.mecaps.socialApp.response.PostResponse;
import com.mecaps.socialApp.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
    @GetMapping("/get")
    public List<PostResponse> getAllPost(){
        return postService.getAllPost();
    }


    @PostMapping("/create")
    public PostResponse createPost(@RequestBody PostRequest request){
        return postService.createPost(request);
    }


    @PutMapping("/update/{id}")
    public PostResponse updatePost(@PathVariable Long id, @RequestBody PostRequest request){

        return postService.updatePost(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public String deletePost(@PathVariable Long id){
        return postService.deletePost(id);
    }


}
