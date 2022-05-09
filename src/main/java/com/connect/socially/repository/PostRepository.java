package com.connect.socially.repository;

import com.connect.socially.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findPostsByUser_Id(Long id);

    Post findPostById(Long id);

}
