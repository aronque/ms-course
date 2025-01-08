package org.example.feignclients;

import org.example.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "hr-user", path = "/users")
public interface UserFeignClient {

    @GetMapping("/{id}")
    ResponseEntity<User> findById(@PathVariable Long id);

    @GetMapping("/search")
    ResponseEntity<User> findByEmail(@RequestParam String email);
}