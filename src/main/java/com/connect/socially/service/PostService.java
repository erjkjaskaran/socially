package com.connect.socially.service;

import com.connect.socially.model.Post;
import com.connect.socially.web.dto.PostDto;

import java.util.List;

public interface PostService {
    Post save(PostDto postDto);
    List<Post> findAll();
}
