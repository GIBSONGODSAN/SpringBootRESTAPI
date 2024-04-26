package com.gibson.gibson.service;

import org.springframework.beans.factory.annotation.Autowired; // Add missing import statement
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; // Add missing import statement
import com.gibson.gibson.domain.User; // Add missing import statement
import com.gibson.gibson.repository.UserRepository; // Add missing import statement

@Service
public class userService {
    @Autowired
    private UserRepository userRepository; // Inject UserRepository for user data access

    @Autowired
    private BCryptPasswordEncoder passwordEncoder; // Inject PasswordEncoder for secure password hashing

    public User registerUser(User user) {
        // Implement user registration logic (validation, etc.)
        user.setPassword(passwordEncoder.encode(user.getPassword())); 
        return userRepository.save(user);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User authenticate(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user;
        }
        return null; // Authentication failed
    }

    public User updateMembership(String email, boolean isMember) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return null;
        }
        user.setIsMember(isMember);
        return userRepository.save(user); // Saves the updated user
      }
      
  }
