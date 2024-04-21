package com.gibson.gibson.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gibson.gibson.domain.LoginRequest;
import com.gibson.gibson.domain.LoginResponse;
import com.gibson.gibson.domain.User;
import com.gibson.gibson.service.userService;
import com.gibson.gibson.util.JwtUtil;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private userService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        User user = userService.authenticate(loginRequest.getEmail(), loginRequest.getPassword());

        if (user != null) {
            String jwtToken = jwtUtil.generateToken(user);
            Boolean isMember = user.getIsMember();
            String email = user.getEmail();
            return new ResponseEntity<>(new LoginResponse(true, "Login successful!", jwtToken, isMember, email), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new LoginResponse(false, "Invalid email or password", null, null, null), HttpStatus.BAD_REQUEST);
        }
    }

    // private static final String SECRET_KEY = "narselmary"; // Corrected variable name

    // private String generateJwtToken(User user) {
    //     try {
    //         Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
    //         return JWT.create()
    //                 .withSubject(user.getUsername()) // Use user's username as subject
    //                 .withClaim("userId", user.getId())
    //                 .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // Set expiration time
    //                 .sign(algorithm);
    //     } catch (JWTCreationException exception) {
    //         throw new RuntimeException("Failed to create JWT token", exception);
    //     }
    // }
}
