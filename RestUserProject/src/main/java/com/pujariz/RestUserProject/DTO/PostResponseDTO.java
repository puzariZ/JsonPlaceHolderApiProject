package com.pujariz.RestUserProject.DTO;

import com.pujariz.RestUserProject.Entity.Post;

public class PostResponseDTO {
    private long id;
    private String title;
    private String body;
    private long userId;

    public PostResponseDTO(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.body = post.getBody();
        this.userId = post.getUser().getId(); // Set only the user ID
    }


    //Getters and setters


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
