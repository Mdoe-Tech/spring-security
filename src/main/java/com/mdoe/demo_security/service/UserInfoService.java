package com.mdoe.demo_security.service;

import com.mdoe.demo_security.model.User;
import com.mdoe.demo_security.model.UserInfoDetails;
import com.mdoe.demo_security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInfoService implements UserDetailsService {

    @Autowired
    private  UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        return user.map(UserInfoDetails::new).orElseThrow(()->new UsernameNotFoundException("The User " + username + " was not found"));
    }
}
