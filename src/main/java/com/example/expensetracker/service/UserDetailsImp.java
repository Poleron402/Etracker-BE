package com.example.expensetracker.service;

import com.example.expensetracker.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsImp implements UserDetailsService {

    private final UserRepository userRepository;
    public UserDetailsImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username){
        return userRepository.findByEmail(username).orElseThrow(()->new UsernameNotFoundException("User not found"));
    }
}
