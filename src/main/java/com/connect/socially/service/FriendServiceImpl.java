package com.connect.socially.service;

import com.connect.socially.model.Friend;
import com.connect.socially.model.User;
import com.connect.socially.repository.FriendRepository;
import com.connect.socially.web.dto.FriendDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class FriendServiceImpl implements FriendService{
    @Autowired
    private FriendRepository friendRepository;


    @Override
    public Friend save(FriendDto friendDto) {
        Friend friend=new Friend(friendDto.getUser_id(), friendDto.getFriend_id(), friendDto.getStatus());
        return friendRepository.save(friend);
    }

    @Override
    public List<User> findFriendByUser_id(User user) {
        return  friendRepository.getFriendFriendidByUserid(user);
    }
}
