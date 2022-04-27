package com.connect.socially.repository;

import com.connect.socially.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    <List>Post findPostsByUser_Id(Long id);
}
