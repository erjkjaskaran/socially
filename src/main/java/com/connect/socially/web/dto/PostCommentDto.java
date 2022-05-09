package com.connect.socially.web.dto;

import com.connect.socially.model.Post;
import com.connect.socially.model.User;


public class PostCommentDto {

    private Post post;
    private String description;
    private User user;

    public PostCommentDto() {

    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public PostCommentDto(Post post, String description, User user) {
        this.post = post;
        this.description = description;
        this.user = user;
    }
}
