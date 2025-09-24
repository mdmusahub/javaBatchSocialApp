package com.mecaps.socialApp.service;


import com.mecaps.socialApp.entity.Post;
import com.mecaps.socialApp.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    public List<Post> getAllPost() {
        return postRepository.findAll();
    }
}
