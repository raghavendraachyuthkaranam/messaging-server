package com.messaging.server.service;

import com.messaging.server.model.User;
import com.messaging.server.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.messaging.server.dto.UserRegistrationRequest;
import com.messaging.server.exception.DuplicateUserException;

@Service
public class UserService {

    private final UserRepository userRepository;

    // Constructor Dependency Injection
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Register a new user
    public User registerUser(UserRegistrationRequest request) {

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new DuplicateUserException("Username already exists");
        }

        if (userRepository.existsByMobileNumber(request.getMobileNumber())) {
            throw new DuplicateUserException("Mobile number already registered");
        }

        User user = new User();

        user.setUsername(request.getUsername());
        user.setDisplayName(request.getDisplayName());
        user.setDateOfBirth(request.getDateOfBirth());
        user.setMobileNumber(request.getMobileNumber());

        return userRepository.save(user);
    }

    // Retrieve all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Retrieve user by ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
}