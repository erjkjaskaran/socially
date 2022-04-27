package com.connect.socially.model;

import javax.persistence.*;

@Entity
@Table(name="post", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String post;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User user;

    public Post(String post, User user) {
        this.post = post;
        this.user = user;
    }


    public Post() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

}
