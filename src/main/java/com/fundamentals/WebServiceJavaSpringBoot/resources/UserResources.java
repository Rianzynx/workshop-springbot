package com.fundamentals.WebServiceJavaSpringBoot.resources;

import com.fundamentals.WebServiceJavaSpringBoot.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( value = "/users")
public class UserResources {

    @GetMapping
    public ResponseEntity<User> findAll() {
        User u = new User(1L , "Maria", "maria@gmail.com", "14998898989", "1234");
        return ResponseEntity.ok().body(u);
    }
}
