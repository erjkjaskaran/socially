package com.connect.socially.service;

import com.connect.socially.model.Requests;
import com.connect.socially.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RequestsService {
    Requests save(Requests requests);

    Long delete(User user, User requestinguser);

    List<User> getUseridByRequestingId(User user);
}
