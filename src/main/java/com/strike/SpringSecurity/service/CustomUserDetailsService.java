package com.strike.SpringSecurity.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.strike.SpringSecurity.model.User;
import com.strike.SpringSecurity.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        // Database se user find karna
        User user = userRepository.findByUsername(username)
                .orElseThrow(() ->
                    new UsernameNotFoundException("User not found: " + username)
                );

        // Spring Security UserDetails object return karna
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .build();
    }
}