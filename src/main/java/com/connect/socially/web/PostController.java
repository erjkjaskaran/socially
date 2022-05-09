package com.connect.socially.web;

import com.connect.socially.model.Post;
import com.connect.socially.model.User;
import com.connect.socially.service.PostService;
import com.connect.socially.service.UserService;
import com.connect.socially.web.dto.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;


@Controller
@RequestMapping("/posts")
public class PostController {

    private PostService postService;

    @Autowired
    private UserService userService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/create")
    public String create_post(@ModelAttribute("post") PostDto postDto, Principal principal){
        User user=userService.findUserByEmail(principal.getName());
        postDto.setUser(user);
        postService.save(postDto);
        return "redirect:posts";
    }

    @GetMapping("/posts")
    public String posts(Model model, Principal principal){
        User user=userService.findUserByEmail(principal.getName());
        String friend_count= String.valueOf((user.getFriends()).size());
        String request_count=String.valueOf((user.getRequests()).size());
        model.addAttribute("request_count", request_count);
        model.addAttribute("friend_count", friend_count);
        List<Post> post=postService.findAll();
        model.addAttribute("posts",post);
        return "posts";
    }

}
