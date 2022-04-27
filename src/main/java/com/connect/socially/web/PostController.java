package com.connect.socially.web;

import com.connect.socially.model.Post;
import com.connect.socially.service.CurrentUser;
import com.connect.socially.service.PostService;
import com.connect.socially.web.dto.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/posts")
public class PostController {

    private PostService postService;

    @Autowired
    private CurrentUser currentUser;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/create")
    public String create_post(@ModelAttribute("post") PostDto postDto){
        postDto.setUser(currentUser.getCurrentUser());
        postService.save(postDto);
        return "redirect:posts";
    }

    @GetMapping("/posts")
    public String posts(Model model){
        List<Post> post=postService.findAll();
        model.addAttribute("posts",post);
        return "posts";
    }

}
