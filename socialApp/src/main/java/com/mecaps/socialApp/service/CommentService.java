package com.mecaps.socialApp.service;

import com.mecaps.socialApp.response.CommentResponse;
import com.mecaps.socialApp.request.CommentRequest;

import java.util.List;

public interface CommentService {

    CommentResponse createComment(CommentRequest request);

    List<CommentResponse> getAllComment();

    CommentResponse getById(Long id);

    CommentResponse updateComment(Long id, CommentRequest request);

    String deleteComment(Long id);


}
