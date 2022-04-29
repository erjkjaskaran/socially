package com.connect.socially.web.dto;

import com.connect.socially.model.User;

public class FriendDto {
    private User user_id;
    private User friend_id;
    private String status;

    public FriendDto(User user_id, User friend_id, String status) {
        this.user_id = user_id;
        this.friend_id = friend_id;
        this.status = status;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public User getFriend_id() {
        return friend_id;
    }

    public void setFriend_id(User friend_id) {
        this.friend_id = friend_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
