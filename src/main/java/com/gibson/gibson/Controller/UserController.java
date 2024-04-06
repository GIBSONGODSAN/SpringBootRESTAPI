package com.gibson.gibson.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.gibson.gibson.domain.User;
import com.gibson.gibson.service.userService; // Import UserService
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users") // Base path for user API endpoints
public class UserController {

    @Autowired
    private userService userService; // Inject UserService

    // This method will handle the POST request for user creation
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.registerUser(user); // Use registerUser for secure storage
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
}
