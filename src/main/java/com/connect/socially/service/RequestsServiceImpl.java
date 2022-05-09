package com.connect.socially.service;


import com.connect.socially.model.Requests;
import com.connect.socially.model.User;
import com.connect.socially.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RequestsServiceImpl implements RequestsService{

    @Autowired
    private RequestRepository requestRepository;

    @Override
    public Requests save(Requests requests) {
        return requestRepository.save(requests);
    }

    @Override
    @Transactional
    public Long delete(User user, User requestinguser) {
        return requestRepository.deleteByUseridAndRequestingid(user, requestinguser);
    }

    @Override
    public List<User> getUseridByRequestingId(User user) {
        return requestRepository.getUseridByRequestingId(user);
    }
}
