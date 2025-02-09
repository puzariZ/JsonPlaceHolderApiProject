package com.pujariz.RestUserProject.Controller;

import com.pujariz.RestUserProject.DTO.PostResponseDTO;
import com.pujariz.RestUserProject.Entity.Post;
import com.pujariz.RestUserProject.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("/post")
    public List<PostResponseDTO> getAllPost(){
        return postService.getAllPost();
    }

//Working..
//    @PostMapping("user/{userId}/post")
//    public Post createPost(@PathVariable long userId, @RequestBody Post post){
//        return postService.createNewPost(userId, post);
//    }

    @PostMapping("/user/{userId}/post")
    public ResponseEntity<PostResponseDTO> createPost(@PathVariable long userId, @RequestBody Post post) {
        Post createdPost = postService.createNewPost(userId, post);
        PostResponseDTO responseDTO = new PostResponseDTO(createdPost); // Create DTO with the new structure
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/user/{userId}/post")
    public ResponseEntity<List<PostResponseDTO>> getPostByUserId(@PathVariable long userId) {
        List<PostResponseDTO> posts = postService.getPostByUserId(userId); // Get the list of PostResponseDTO
        return ResponseEntity.ok(posts); // Wrap the list in a ResponseEntity and return it
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<Post> getPostById(@PathVariable long postId){
        return postService.getPostById(postId);
    }

//    @PutMapping("/{user_id}/{id}")
    @PatchMapping("/user/{userId}/post/{postId}")
    public ResponseEntity<PostResponseDTO> updatePostById(@PathVariable long userId,@PathVariable long postId, @RequestBody Post postDetails){
        Post updatedPost = postService.updatePostById(userId, postId, postDetails);
        PostResponseDTO responseDTO = new PostResponseDTO(updatedPost);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/user/{userId}/post/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable long userId, @PathVariable long postId){
        postService.deletePost(userId, postId);
        return ResponseEntity.noContent().build();
    }

//    @PutMapping("/user/{userId}/post/{postId}")
//    public ResponseEntity<PostResponseDTO> patchUserById(@PathVariable long userId,@PathVariable long postId, @RequestBody Post updatePost){
//        Post updatedPost = postService.updatePost(userId, postId, postDetails);
//        PostResponseDTO responseDTO = new PostResponseDTO(updatedPost);
//        return ResponseEntity.ok(responseDTO);
//    }

}
