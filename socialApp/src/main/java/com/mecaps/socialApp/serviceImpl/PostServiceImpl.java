package com.mecaps.socialApp.serviceImpl;


import com.mecaps.socialApp.entity.Post;
import com.mecaps.socialApp.entity.User;
import com.mecaps.socialApp.repository.PostRepository;
import com.mecaps.socialApp.repository.UserRepository;
import com.mecaps.socialApp.request.PostRequest;
import com.mecaps.socialApp.response.PostResponse;
import com.mecaps.socialApp.service.PostService;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostServiceImpl(PostRepository postRepository,
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
    public PostResponse updatePost(Long id, PostRequest request) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new RuntimeException("post not found")
        );
        post.setContent(request.getContent());
        Post save = postRepository.save(post);
        return new PostResponse(save);
    }
    public String deletePost(Long id){
        Post post = postRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("post id not found")
        );
        postRepository.delete(post);
        return "Deleted successfully";
    }
}
