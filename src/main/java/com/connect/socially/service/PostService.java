package com.connect.socially.service;

import com.connect.socially.model.Post;
import com.connect.socially.web.dto.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PostService {
    Post save(PostDto postDto);
    List<Post> findAll();

    Post findByPostid(Long post_id);
}
