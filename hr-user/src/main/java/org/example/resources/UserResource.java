package org.example.resources;

import org.example.entities.User;
import org.example.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserRepository repository;

    @GetMapping("")
    public ResponseEntity<List<User>> findAll(){
        List<User> result = repository.findAll();
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){

        User result = repository.findById(id).get();
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/search")
    public ResponseEntity<User> findById(@RequestParam String email){

        User result = repository.findByEmail(email);
        return ResponseEntity.ok().body(result);
    }
}