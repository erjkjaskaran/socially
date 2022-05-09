package com.connect.socially.web.dto;

import com.connect.socially.model.Comment;
import com.connect.socially.model.User;


public class CommentCommentDto {

    private Comment comment;
    private String description;
    private User user;

    public CommentCommentDto() {
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
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

    public CommentCommentDto(Comment comment, String description, User user) {
        this.comment = comment;
        this.description = description;
        this.user = user;
    }
}
