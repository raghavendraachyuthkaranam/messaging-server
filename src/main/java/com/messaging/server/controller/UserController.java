package com.messaging.server.controller;

import com.messaging.server.model.User;
import com.messaging.server.service.UserService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import com.messaging.server.dto.UserRegistrationRequest;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;


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
    public ResponseEntity<User> registerUser(
            @Valid @RequestBody UserRegistrationRequest request) {

        User savedUser = userService.registerUser(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedUser);
    }

    // Get all registered users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {

        return ResponseEntity.of(userService.getUserById(id));
    }

}