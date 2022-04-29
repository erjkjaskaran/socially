package com.connect.socially.model;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name="friend", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User userid;

    @ManyToOne
    @JoinColumn(name = "friend_id",nullable = false)
    private User friendid;

    @Column(nullable = false)
    private String status;

    public Friend() {

    }


    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
    }

    public User getFriendid() {
        return friendid;
    }

    public void setFriendid(User friendid) {
        this.friendid = friendid;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public Friend(User userid, User friendid, String status) {
        this.userid = userid;
        this.friendid = friendid;
        this.status = status;
    }

    public Friend(Long id, User userid, User friendid, String status) {
        this.id = id;
        this.userid = userid;
        this.friendid = friendid;
        this.status = status;
    }
}
