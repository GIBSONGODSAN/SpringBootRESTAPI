package com.gibson.gibson.config; // Change the package declaration to match the expected package

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class securityconfig { // Rename the class to start with a capital letter

    @Bean
    public BCryptPasswordEncoder passwordEncoder() { // Define a bean for BCryptPasswordEncoder directly
        return new BCryptPasswordEncoder();
    }
}
