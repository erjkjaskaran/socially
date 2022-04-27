package com.connect.socially.web.dto;

import com.connect.socially.model.User;


public class PostDto {
    private String post;
    private User user;

    public PostDto(String post, User user) {
        this.post = post;
        this.user = user;
    }


    public PostDto() {
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
