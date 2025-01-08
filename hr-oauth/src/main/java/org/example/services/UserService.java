package org.example.services;

import org.example.entities.User;
import org.example.feignclients.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserFeignClient feignClient;

    public User findByEmail(String email) {
        User response = feignClient.findByEmail(email).getBody();

        if(response == null) {
            throw new IllegalArgumentException("Email not found.");
        }

        return response;
    }
}
