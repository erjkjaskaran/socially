package com.connect.socially.service;

import com.connect.socially.model.Friend;
import com.connect.socially.model.User;
import com.connect.socially.repository.FriendRepository;
import com.connect.socially.web.dto.FriendDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FriendServiceImpl implements FriendService{
    @Autowired
    private FriendRepository friendRepository;


    @Override
    public Friend save(FriendDto friendDto) {
        Friend friend=new Friend(friendDto.getUser_id(), friendDto.getFriend_id());
        return friendRepository.save(friend);
    }

    @Override
    public Friend update(Friend friend) {
        return friendRepository.save(friend);
    }

    @Override
    public List<User> findFriendRequestByUser_id(User user) {
        return  friendRepository.getFriendFriendidByUserid(user);
    }

    @Override
    public List<User> findFriendByFriend_id(User user) {
        return friendRepository.getFriendUseridByFriendid(user);
    }

    @Override
    @Transactional
    public Long delete(User user, User friend){
        return friendRepository.deleteByUseridAndFriendid(user, friend);
    }

    @Override
    public Friend findFriendByUseridAndFriendId(User user, User friend) {
        return friendRepository.getFriendByUseridAndFriendid(user, friend);
    }

    @Override
    public void save(User user, User friend) {
        Friend friend1=new Friend(user, friend);
        friendRepository.save(friend1);
    }
}
