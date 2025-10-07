package com.mecaps.socialApp.service;

import java.util.List;
import com.mecaps.socialApp.response.PostResponse;
import com.mecaps.socialApp.request.PostRequest;

public interface PostService {

    List<PostResponse> getAllPost();

    PostResponse createPost(PostRequest postRequest);

    PostResponse updatePost(Long id, PostRequest request);

    String deletePost(Long id);

}
