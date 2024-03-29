package com.connect.socially.service;


import com.connect.socially.model.Role;
import com.connect.socially.model.User;
import com.connect.socially.repository.UserRepository;
import com.connect.socially.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;



    PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

    public UserServiceImpl(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public User findUserByEmail(String email){

        return userRepository.findByEmail(email);
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findUserById(id);
    }

    @Override
    public User save(UserDto registrationDto){
        User user=new User(registrationDto.getFirstName(), registrationDto.getLastName(), registrationDto.getEmail(), passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new Role("ROLE_USER")));
        return userRepository.save(user);
    }

    @Override
    public Collection<User> findAll(){
        return userRepository.findAll();
    }

    @Override
    public User update(User user, User friend) {
        Collection<User> user_friends=user.getFriends();
        Collection<User> friends_friends=friend.getFriends();
        user_friends.remove(friend);
        friends_friends.remove(user);
        userRepository.save(friend);
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByEmail(username);
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),mapRolestoAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolestoAuthorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());
    }


}
