package com.connect.socially.web;

import com.connect.socially.model.Friend;
import com.connect.socially.model.Post;
import com.connect.socially.model.User;
import com.connect.socially.service.CurrentUser;
import com.connect.socially.service.FriendService;
import com.connect.socially.service.UserService;
import com.connect.socially.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CurrentUser currentUser;

    @Autowired
    private FriendService friendService;

    @GetMapping("/registration")
    public String showRegistrationForm(Model model){
        model.addAttribute("user", new UserDto());
        return "registration";
    }

    @PostMapping("/registration")
    public String registerUserAccount(@ModelAttribute("user") UserDto registrationDto){
        userService.save(registrationDto);
        return "redirect:/registration?success";
    }

    @GetMapping("/myposts")
    public String userPosts(Model model){
        User user=currentUser.getCurrentUser();
        Collection<Post> post= (Collection<Post>) user.getPost();
        model.addAttribute("posts",post);
        return "myposts";
    }

    @GetMapping("all")
    public String show_all_user(Model model){
        Collection<User> users = (Collection<User>) userService.findAll();
        User user=currentUser.getCurrentUser();
        System.out.println(friendService.findFriendByUser_id(user));
        List<User> friend= friendService.findFriendByUser_id(user);
        model.addAttribute("users", users);
        model.addAttribute("friends",friend);
        System.out.println(friendService.findFriendByUser_id(user));
        return "users";

    }


}
