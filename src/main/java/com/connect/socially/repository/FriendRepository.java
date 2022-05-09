package com.connect.socially.repository;

import com.connect.socially.model.Friend;
import com.connect.socially.model.User;
import com.connect.socially.web.dto.FriendDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Long> {
    Friend save(Friend friend);

    @Query("select f.friendid from Friend f where f.userid= ?1 ")
    List<User> getFriendFriendidByUserid(User user);

    @Query("select f.userid from Friend f where f.friendid= ?1 ")
    List<User> getFriendUseridByFriendid(User user);

    Long deleteByUseridAndFriendid(User user, User friend);

    Friend getFriendByUseridAndFriendid(User user, User friend);

}
