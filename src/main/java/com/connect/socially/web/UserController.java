package com.connect.socially.web;

import com.connect.socially.model.Post;
import com.connect.socially.model.User;
import com.connect.socially.service.CurrentUser;
import com.connect.socially.service.UserService;
import com.connect.socially.web.dto.UserRegistrationDto;
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

    private UserService userService;

    @Autowired
    private CurrentUser currentUser;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String showRegistrationForm(Model model){
        model.addAttribute("user", new UserRegistrationDto());
        return "registration";
    }

    @PostMapping("/registration")
    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto){
        userService.save(registrationDto);
        return "redirect:/registration?success";
    }

    @GetMapping("/myposts")
    public String userPosts(Model model){
        User user=currentUser.getCurrentUser();
        System.out.println(user.getPost());
        Collection<Post> post= (Collection<Post>) user.getPost();
        model.addAttribute("posts",post);
        return "myposts";
    }
}
