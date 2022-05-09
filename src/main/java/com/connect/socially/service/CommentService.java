package com.connect.socially.service;

import com.connect.socially.model.Comment;
import com.connect.socially.web.dto.PostCommentDto;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {
    Comment save(PostCommentDto postCommentDto);
}
