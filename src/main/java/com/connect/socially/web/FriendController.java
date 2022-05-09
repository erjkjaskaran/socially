package com.connect.socially.web;

import com.connect.socially.model.Friend;
import com.connect.socially.model.Requests;
import com.connect.socially.model.User;
import com.connect.socially.service.FriendService;
import com.connect.socially.service.RequestsService;
import com.connect.socially.service.UserService;
import com.connect.socially.web.dto.FriendDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
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
    private RequestsService requestsService;

    @GetMapping("/{user_id}/request")
    public String add_request(@PathVariable Long user_id, Principal principal){
         User userid=userService.findUserById(user_id);
         User requestinguserid=userService.findUserByEmail(principal.getName());
         Requests request= new Requests(userid, requestinguserid);
         requestsService.save(request);
         return "redirect:/user/all";
    }

    @GetMapping("/{user_id}/cancelrequest")
    public String cancel_request(@PathVariable Long user_id, Principal principal){
        User requestinguserid=userService.findUserByEmail(principal.getName());
        Long count=requestsService.delete(userService.findUserById(user_id), requestinguserid);
        System.out.println(count);
        return "redirect:/user/all";
    }

    @GetMapping("/requests")
    public String show_requests(Model model, Principal principal){
        User current_user=userService.findUserByEmail(principal.getName());
        List<User> user= (List<User>) current_user.getRequests();
        String friend_count= String.valueOf((current_user.getFriends()).size());
        String request_count=String.valueOf((current_user.getRequests()).size());
        model.addAttribute("request_count", request_count);
        model.addAttribute("friend_count", friend_count);
        model.addAttribute("users",user);
        return "requests";
    }

    @GetMapping("/{user_id}/accept")
    public String accept_request(@PathVariable Long user_id, Principal principal) {
        User friend = userService.findUserById(user_id);
        User user = userService.findUserByEmail(principal.getName());
        requestsService.delete(user, friend);
        friendService.save(user,friend);
        friendService.save(friend,user);
        return "redirect:/friend/requests";
    }

    @GetMapping("/all")
    public String show_friends(Model model, Principal principal) {
        User current_user = userService.findUserByEmail(principal.getName());
        List<User> user = (List<User>) current_user.getFriends();
        String friend_count= String.valueOf((current_user.getFriends()).size());
        String request_count=String.valueOf((current_user.getRequests()).size());
        model.addAttribute("request_count", request_count);
        model.addAttribute("friend_count", friend_count);
        model.addAttribute("users", user);
        return "friends";
    }

    @GetMapping("/{user_id}/remove")
    public String remove_friend(@PathVariable Long user_id, Principal principal){
        User user=userService.findUserByEmail(principal.getName());
        User friend=userService.findUserById(user_id);
        userService.update(user, friend);
        return "redirect:/user/all";
    }


}
