package com.mecaps.socialApp.serviceImpl;


import com.mecaps.socialApp.entity.Comment;
import com.mecaps.socialApp.entity.Post;
import com.mecaps.socialApp.entity.User;
import com.mecaps.socialApp.repository.CommentRepository;
import com.mecaps.socialApp.repository.PostRepository;
import com.mecaps.socialApp.repository.UserRepository;
import com.mecaps.socialApp.request.CommentRequest;
import com.mecaps.socialApp.response.CommentResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public CommentServiceImpl(CommentRepository commentRepository,
                              UserRepository userRepository, PostRepository postRepository) {

        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }


    public CommentResponse createComment(CommentRequest request) {
        User user = userRepository.findById(request.getUserId()).orElseThrow(
                () -> new RuntimeException("user not found")
        );
        Post post = postRepository.findById(request.getPostId()).orElseThrow(
                () -> new RuntimeException("post not found")
        );

        Comment comment = new Comment();
        comment.setCommentString(request.getCommentString());
        comment.setAuthor(user);
        comment.setPostId(post);
        Comment save = commentRepository.save(comment);
        return new CommentResponse(save);
//        return save;

    }

    public List<CommentResponse> getAllComment() {
        List<Comment> all = commentRepository.findAll();

//        List<CommentResponse> commentResponses = new ArrayList<>();
//
//        for (Comment comment: all){
//            CommentResponse commentResponse = new CommentResponse(comment);
//            commentResponses.add(commentResponse);
//        }
//        return commentResponses;
        return all.stream().map((CommentResponse::new)).toList();
    }

    public CommentResponse getById(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new RuntimeException("not found")
        );
        return new CommentResponse(comment);
//        return comment;
    }

    public CommentResponse updateComment(Long id,
                                         CommentRequest request) {
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new RuntimeException("not found")
        );
        comment.setCommentString(request.getCommentString());
        Comment save = commentRepository.save(comment);
        return new CommentResponse(save);
//        return save;

    }

    public String deleteComment(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("not found"));

        commentRepository.delete(comment);
        return "Deleted";
    }
}

