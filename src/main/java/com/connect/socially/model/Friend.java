package com.connect.socially.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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



    public Friend(User userid, User friendid) {
        this.userid = userid;
        this.friendid = friendid;
    }


}
