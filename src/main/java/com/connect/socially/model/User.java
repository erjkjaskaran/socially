package com.connect.socially.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user",uniqueConstraints = @UniqueConstraint(columnNames="email"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

    @OneToMany(mappedBy = "user", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<Post> post;

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
            name="requests",
            joinColumns = @JoinColumn(
                    name="user_id", referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name="requestinguser_id", referencedColumnName = "id"
            )
    )
    private Collection<User> requests;

    @ManyToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name="friend",
            joinColumns = @JoinColumn(
                    name="user_id", referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name="friend_id", referencedColumnName = "id"
            )
    )
    private Collection<User> friends;

    public User(String firstName, String lastName, String email, String password, Collection<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public Collection<Post> getPost() {
        return post;
    }

    public void setPost(Collection<Post> post) {
        this.post = post;
    }

    public Collection<User> getRequests() {
        return requests;
    }

    public void setRequests(Collection<User> requests) {
        this.requests = requests;
    }

    public Collection<User> getFriends() {
        return friends;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFriends(Collection<User> friends) {
        this.friends = friends;
    }
}
