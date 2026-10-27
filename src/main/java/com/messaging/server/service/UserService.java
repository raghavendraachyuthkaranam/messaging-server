package com.messaging.server.service;

import com.messaging.server.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    // Temporarily store registered users in memory
    private final List<User> users = new ArrayList<>();

    // Register a new user
    public User registerUser(User user) {

        users.add(user);

        return user;
    }

    // Retrieve all registered users
    public List<User> getAllUsers() {

        return users;
    }

    // Implement GET User by ID
    public Optional<User> getUserById(Long id) {

        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }
}