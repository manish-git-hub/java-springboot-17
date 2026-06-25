package com.example.crudapp.service;

import com.example.crudapp.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    
    User createUser(User user);
    
    Optional<User> getUserById(Long id);
    
    List<User> getAllUsers();
    
    User updateUser(Long id, User user);
    
    void deleteUser(Long id);
    
    Optional<User> getUserByEmail(String email);
}

// Made with Bob
