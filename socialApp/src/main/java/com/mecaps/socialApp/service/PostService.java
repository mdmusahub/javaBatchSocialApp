package com.mecaps.socialApp.service;


import com.mecaps.socialApp.entity.Post;
import com.mecaps.socialApp.entity.User;
import com.mecaps.socialApp.repository.PostRepository;
import com.mecaps.socialApp.repository.UserRepository;
import com.mecaps.socialApp.request.PostRequest;
import com.mecaps.socialApp.response.PostResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostService(PostRepository postRepository,
                       UserRepository userRepository) {

        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public List<PostResponse> getAllPost() {
        List<Post>  postList = postRepository.findAll();
        // stream
        return postList.stream().map(PostResponse::new).toList();

        // by loop
//        List<PostResponse> postResponseList = new ArrayList<>();
//        for (Post post : postList){
//            PostResponse postResponse = new PostResponse(post);
//            postResponseList.add(postResponse);
//        }
//        return postResponseList;


    }

    public PostResponse createPost(PostRequest postRequest){

        User user = userRepository.findById(postRequest.getAuthor())
                .orElseThrow( () -> new RuntimeException("User id not found"));

        Post post = new Post();
        post.setContent(postRequest.getContent());
        post.setAuthor(user);
        Post save = postRepository.save(post);
        return new PostResponse(save);
    }


}
