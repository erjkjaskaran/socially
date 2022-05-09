package com.connect.socially.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Comment", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="post_id", referencedColumnName = "id")
    private Post post;

    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="comments_id", referencedColumnName = "id")
    private List<Comment> comment_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Comment(Post post, String description, User user) {
        this.post = post;
        this.description = description;
        this.user=user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Comment> getComment_id() {
        return comment_id;
    }

    public void setComment_id(List<Comment> comment_id) {
        this.comment_id = comment_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
