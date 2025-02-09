package com.pujariz.RestUserProject.Service;

import com.pujariz.RestUserProject.DTO.PostResponseDTO;
import com.pujariz.RestUserProject.DTO.UserDTO;
import com.pujariz.RestUserProject.Entity.Post;
import com.pujariz.RestUserProject.Entity.User;
import com.pujariz.RestUserProject.Repository.PostRepository;
import com.pujariz.RestUserProject.Repository.UserRepository;
import com.pujariz.RestUserProject.ServiceInterface.PostServiceble;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService implements PostServiceble {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    @Override
    public List<PostResponseDTO> getAllPost() {
        List<Post> posts = postRepository.findAll();
        return posts.stream()
                .map(PostResponseDTO::new) // Convert each Post to PostResponseDTO
                .collect(Collectors.toList());
    }

// Creating post for an user id but sending all data
//    @Override
//    public Post createNewPost(long userId, Post post) {
//        Optional<User> userOptional = userRepository.findById(userId);
//        if(userOptional.isPresent()){
//            post.setUser(userOptional.get());
//            return postRepository.save(post);
//        }
//        else{
//            throw new RuntimeException("User Not found with this "+ userId);
//        }
////        return postRepository.save(post);
//    }

@Override
public Post createNewPost(long userId, Post post) {
    Optional<User> userOptional = userRepository.findById(userId);
    if (userOptional.isPresent()) {
        User user = userOptional.get(); // Get the existing User entity
        post.setUser (user); // Set the User entity in the Post
        return postRepository.save(post); // Save the post
    } else {
        throw new RuntimeException("User  not found with ID: " + userId); // Handle user not found
    }
}


    @Override
    public List<PostResponseDTO> getPostByUserId(long userId) {
        List<Post> posts = postRepository.findByUser_Id(userId);
        return posts.stream()
                .map(PostResponseDTO::new) // Convert each Post to PostResponseDTO
                .collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<Post> getPostById(long postId) {
        return null;
    }

    @Override
    public Post updatePostById(long userId, long postId, Post postDetails) {
        // Find the post by ID
        Optional<Post> optionalPost = postRepository.findById(postId);
        if (!optionalPost.isPresent()) {
            throw new RuntimeException("Post not found with ID: " + postId);
        }

        Post existingPost = optionalPost.get();

        // Check if the user ID matches the post's user
        if (existingPost.getUser () == null || existingPost.getUser ().getId() != userId) {
            throw new RuntimeException("User  ID does not match the post's user.");
        }

        // Update the fields of the existing post
        if (postDetails.getTitle() != null) {
            existingPost.setTitle(postDetails.getTitle());
        }
        if (postDetails.getBody() != null) {
            existingPost.setBody(postDetails.getBody());
        }

        // Save the updated post
        return postRepository.save(existingPost);
    }

    @Override
    public void deletePost(long userId, long postId) {
        // Find the post by ID
        Optional<Post> optionalPost = postRepository.findById(postId);
        if (!optionalPost.isPresent()) {
            throw new RuntimeException("Post not found with ID: " + postId);
        }

        Post existingPost = optionalPost.get();

        // Check if the user ID matches the post's user
        if (existingPost.getUser () == null || existingPost.getUser ().getId() != userId) {
            throw new RuntimeException("User  ID does not match the post's user.");
        }

        // Delete the post
        postRepository.delete(existingPost);

    }

//    @Override
//    public ResponseEntity<Post> patchUserById(long userId, long postId, Post updatePost) {
//        return null;
//    }

}
