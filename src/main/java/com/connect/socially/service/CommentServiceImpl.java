package com.connect.socially.service;

import com.connect.socially.model.Comment;
import com.connect.socially.repository.CommentRepository;
import com.connect.socially.web.dto.PostCommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;


    @Override
    public Comment save(PostCommentDto postCommentDto) {
        Comment comment=new Comment(postCommentDto.getPost(), postCommentDto.getDescription(), postCommentDto.getUser());
        return commentRepository.save(comment);
    }
}
