package com.connect.socially.service;

import com.connect.socially.model.User;
import com.connect.socially.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);

    User findUserByEmail(String email);
}
