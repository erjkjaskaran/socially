package com.connect.socially.service;

import com.connect.socially.model.Post;
import com.connect.socially.repository.PostRepository;
import com.connect.socially.web.dto.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post save(PostDto postDto) {
        Post post= new Post(postDto.getPost(), postDto.getUser());
        return postRepository.save(post);
    }

    @Override
    public List<Post> findAll(){
        return postRepository.findAll();
    }

    @Override
    public Post findByPostid(Long post_id) {
        return postRepository.findPostById(post_id);
    }


}
