package com.connect.socially.web;

import com.connect.socially.model.User;
import com.connect.socially.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/")
    public String home(Principal principal, Model model) {
        User user=userService.findUserByEmail(principal.getName());
        String friend_count= String.valueOf((user.getFriends()).size());
        String request_count=String.valueOf((user.getRequests()).size());
        model.addAttribute("request_count", request_count);
        model.addAttribute("friend_count", friend_count);
        return "main";
    }
}
