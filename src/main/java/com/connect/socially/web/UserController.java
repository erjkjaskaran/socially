package com.connect.socially.web;

import com.connect.socially.model.Post;
import com.connect.socially.model.User;
import com.connect.socially.service.RequestsService;
import com.connect.socially.service.UserService;
import com.connect.socially.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RequestsService requestsService;

    @GetMapping("/registration")
    public String showRegistrationForm(Model model){
        model.addAttribute("user", new UserDto());
        return "registration";
    }

    @PostMapping("/registration")
    public String registerUserAccount(@ModelAttribute("user") UserDto registrationDto){
        userService.save(registrationDto);
        return "redirect:/user/registration?success";
    }

    @GetMapping("/myposts")
    public String userPosts(Model model, Principal principal){
        User user=userService.findUserByEmail(principal.getName());
        Collection<Post> post= (Collection<Post>) user.getPost();
        model.addAttribute("posts",post);
        String friend_count= String.valueOf((user.getFriends()).size());
        String request_count=String.valueOf((user.getRequests()).size());
        model.addAttribute("request_count", request_count);
        model.addAttribute("friend_count", friend_count);
        return "myposts";
    }

    @GetMapping("all")
    public String show_all_user(Model model, Principal principal){
        Collection<User> users = userService.findAll();
        User user=userService.findUserByEmail(principal.getName());
        users.remove(user);
        List<User> requestsent= requestsService.getUseridByRequestingId(user);
        List<User> requestreceived= (List<User>) user.getRequests();
        List<User> friends= (List<User>) user.getFriends();
        String friend_count= String.valueOf(friends.size());
        String request_count=String.valueOf(requestreceived.size());
        model.addAttribute("request_count", request_count);
        model.addAttribute("friend_count", friend_count);
        model.addAttribute("users", users);
        model.addAttribute("requestsent",requestsent);
        model.addAttribute("requestreceived", requestreceived);
        model.addAttribute("friends", friends);
        return "users";

    }


}
