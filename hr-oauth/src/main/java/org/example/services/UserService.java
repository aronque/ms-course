package org.example.services;

import org.example.entities.User;
import org.example.feignclients.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserFeignClient feignClient;

    public User findByEmail(String email) {
        User response = feignClient.findByEmail(email).getBody();

        if(response == null) {
            throw new IllegalArgumentException("Email not found.");
        }

        return response;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User response = feignClient.findByEmail(s).getBody();

        if(response == null) {
            throw new UsernameNotFoundException("Email not found.");
        }

        return response;
    }
}
