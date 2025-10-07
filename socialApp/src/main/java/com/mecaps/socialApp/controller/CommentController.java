package com.mecaps.socialApp.controller;


import com.mecaps.socialApp.entity.Comment;
import com.mecaps.socialApp.request.CommentRequest;
import com.mecaps.socialApp.response.CommentResponse;
import com.mecaps.socialApp.response.PostResponse;
import com.mecaps.socialApp.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/create")
    public CommentResponse createComment(@RequestBody
                                         CommentRequest request){
        return commentService.createComment(request);
    }

    @GetMapping("/get")
    public List<CommentResponse> getAllComment(){
        return commentService.getAllComment();
    }

    @GetMapping("/get/{id}")
    public CommentResponse getById(@PathVariable Long id){
        return commentService.getById(id);
    }

    @PutMapping("/update/{id}")
    public CommentResponse updateComment(@PathVariable Long id,
                                         @RequestBody CommentRequest request){
        return commentService.updateComment(id,request);

    }

    @DeleteMapping("/delete/{id}")
    public String deleteComment(@PathVariable Long id)
    {
        return commentService.deleteComment(id);
    }
}
