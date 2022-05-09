package com.connect.socially.web;

import com.connect.socially.model.Post;
import com.connect.socially.model.User;
import com.connect.socially.service.CommentService;
import com.connect.socially.service.PostService;
import com.connect.socially.service.UserService;
import com.connect.socially.web.dto.PostCommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @GetMapping("/post/{post_id}")
    public String post_comment(@PathVariable Long post_id, Model model){
        Post post=postService.findByPostid(post_id);
        System.out.println(post.getComments());
        model.addAttribute("post", post);
        model.addAttribute("comment", new PostCommentDto());
        return "comment";
    }

    @PostMapping("/create")
    public String comment_create(@ModelAttribute("comment") PostCommentDto postCommentDto, Principal principal){
        User user=userService.findUserByEmail(principal.getName());
        postCommentDto.setUser(user);
        commentService.save(postCommentDto);
        return "redirect:/posts/posts";
    }
}
