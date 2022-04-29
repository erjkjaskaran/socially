package com.connect.socially.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="post", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String post;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User user;


}
