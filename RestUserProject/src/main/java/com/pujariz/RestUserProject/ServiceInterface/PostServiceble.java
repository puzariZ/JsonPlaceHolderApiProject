package com.pujariz.RestUserProject.ServiceInterface;

import com.pujariz.RestUserProject.DTO.PostResponseDTO;
import com.pujariz.RestUserProject.Entity.Post;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PostServiceble {

    public List<PostResponseDTO> getAllPost();

    public Post createNewPost(@PathVariable long userId, @RequestBody Post post);

    public List<PostResponseDTO> getPostByUserId(@PathVariable long userId);

    public ResponseEntity<Post> getPostById(@PathVariable long postId);

    public Post updatePostById(@PathVariable long userId,@PathVariable long postId, @RequestBody Post postDetails);

    public void deletePost(@PathVariable long userId, @PathVariable long postId);

}
