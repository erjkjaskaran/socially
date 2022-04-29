package com.connect.socially.service;

import com.connect.socially.model.Friend;
import com.connect.socially.model.User;
import com.connect.socially.web.dto.FriendDto;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public interface FriendService{
    Friend save(FriendDto friendDto);

    List<User> findFriendByUser_id(User user);
}
