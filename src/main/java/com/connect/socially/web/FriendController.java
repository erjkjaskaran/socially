package com.connect.socially.web;

import com.connect.socially.model.Friend;
import com.connect.socially.model.User;
import com.connect.socially.service.CurrentUser;
import com.connect.socially.service.FriendService;
import com.connect.socially.service.UserService;
import com.connect.socially.web.dto.FriendDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/friend")
public class FriendController {
    @Autowired
    private FriendService friendService;

    @Autowired
    private UserService userService;

    @Autowired
    private CurrentUser currentUser;

    @GetMapping("/{user_id}/request")
    public String add_friend(@PathVariable Long user_id){
         User friend=userService.findUserById(user_id);
         User user=currentUser.getCurrentUser();
         FriendDto request= new FriendDto(user,friend, "request");
         friendService.save(request);
         return "redirect:/user/all";
    }

    @GetMapping("/requests")
    public String show_requests(Model model){
        User current_user=currentUser.getCurrentUser();
        List<User> user=friendService.findFriendByUser_id(current_user);
        model.addAttribute("user",user);
        return "requests";
    }
}
