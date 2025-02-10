package com.pujariz.RestUserProject.Controller;

import com.pujariz.RestUserProject.Entity.Comments;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CommentsController {

    @GetMapping("post/{postId}/comments")
    public List<Comments> getAllCommentsByPostId(@PathVariable long postId){
        return null;
    }
}
