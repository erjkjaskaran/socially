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

    Friend update(Friend friend);

    List<User> findFriendRequestByUser_id(User user);

    List<User> findFriendByFriend_id(User user);

    Long delete(User user, User friend);

    Friend findFriendByUseridAndFriendId(User user, User friend);

    void save(User user, User friend);
}
