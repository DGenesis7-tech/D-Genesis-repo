package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Security Configuration
 * 
 * Provides BCryptPasswordEncoder bean for secure password and PIN hashing.
 * BCrypt automatically generates random salt and uses 10 iterations (configurable).
 * 
 * Usage:
 * - Password hashing: bCryptPasswordEncoder.encode(rawPassword)
 * - Password verification: bCryptPasswordEncoder.matches(rawPassword, hashedPassword)
 * - PIN hashing: Same as password
 * 
 * BCrypt Format: $2b$10$salt+hash
 * - $2b$ = BCrypt version
 * - $10$ = Number of rounds (2^10 iterations)
 * - salt+hash = Random salt + computed hash
 */
@Configuration
public class SecurityConfig {

    /**
     * BCryptPasswordEncoder Bean
     * 
     * - Strength: 10 (default, balances security and speed)
     * - Each password gets unique random salt
     * - Salts are included in the output hash
     * - Comparing two BCrypt hashes with same password gives DIFFERENT results
     * - Verification uses: encoder.matches(rawPassword, hashedPassword)
     * 
     * @return BCryptPasswordEncoder configured with strength 10
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        // Strength 10 = 2^10 = 1024 iterations (good balance)
        // Strength 12 = 2^12 = 4096 iterations (more secure, slower)
        return new BCryptPasswordEncoder(10);
    }
}
