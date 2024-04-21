package com.gibson.gibson.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gibson.gibson.domain.User;
import com.gibson.gibson.service.userService;

@RestController
@CrossOrigin(origins = "*") // Adjust for production (allow specific origins)
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private userService userService;

    // This method will handle the POST request for user creation
    @PostMapping
    public ResponseEntity<User> createUser(@Validated @RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
        }

        User savedUser = userService.registerUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
}
