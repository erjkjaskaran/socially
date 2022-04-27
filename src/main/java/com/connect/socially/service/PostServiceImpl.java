package com.connect.socially.service;

import com.connect.socially.model.Post;
import com.connect.socially.repository.PostRepository;
import com.connect.socially.web.dto.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post save(PostDto postDto) {
        Post post= new Post(postDto.getPost(), postDto.getUser());
        return postRepository.save(post);
    }

    @Override
    public List<Post> findAll(){
        return postRepository.findAll();
    }
}
