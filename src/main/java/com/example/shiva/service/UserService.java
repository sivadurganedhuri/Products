package com.example.shiva.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.shiva.models.User;
import com.example.shiva.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String register(User user) {
        if (repo.findByUsername(user.getUsername()) != null) {
            return "User already exists!";
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            repo.save(user);
            return "User registered successfully";
        }
    }

    public boolean validateUser(String username, String password) {
        User existingUser = repo.findByUsername(username);
        return existingUser != null && passwordEncoder.matches(password, existingUser.getPassword());
    }
}