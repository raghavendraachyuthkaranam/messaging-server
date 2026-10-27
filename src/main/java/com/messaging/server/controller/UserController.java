package com.messaging.server.controller;

import com.messaging.server.model.User;
import com.messaging.server.service.UserService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    // Constructor Injection
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Register a new user
    @PostMapping
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    // Get all registered users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}