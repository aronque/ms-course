package org.example.resources;

import org.example.entities.User;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserService service;


    @GetMapping("/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email) {
        User response = service.findByEmail(email);

        return ResponseEntity.ok(response);
    }
}
