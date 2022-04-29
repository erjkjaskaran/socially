package com.connect.socially.service;

import com.connect.socially.model.User;
import com.connect.socially.web.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface UserService extends UserDetailsService {
    User save(UserDto userDto);

    User findUserByEmail(String email);

    User findUserById(Long id);

    Collection<User> findAll();
}
