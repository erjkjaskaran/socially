package com.connect.socially.service;

import com.connect.socially.model.User;
import com.connect.socially.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class CurrentUser {
    private User user;

    @Autowired
    private UserService userService;

    public User getCurrentUser() {
        if (user == null) {
            org.springframework.security.core.userdetails.User user1= (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            user = userService.findUserByEmail(user1.getUsername());
        }
        return user;
    }
}
