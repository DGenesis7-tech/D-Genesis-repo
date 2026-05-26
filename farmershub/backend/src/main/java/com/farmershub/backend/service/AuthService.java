package com.farmershub.backend.service;

import com.farmershub.backend.dto.*;
import com.farmershub.backend.dto.request.LoginRequest;
import com.farmershub.backend.dto.response.AuthResponse;
import com.farmershub.backend.dto.request.RegisterRequest;
import com.farmershub.backend.model.*;
import com.farmershub.backend.repository.UserRepository;
import com.farmershub.backend.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor // Lombok: injects all final fields via constructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already registered");
        }

        User user = User.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .status(request.getStatus())
                .build();

        userRepository.save(user);

        String token = jwtService.generateToken(user);
        return new AuthResponse(token, user.getEmail(), user.getFullName(),
                user.getRole().name(), user.getId());
    }

    public AuthResponse login(LoginRequest request) {
        // This throws BadCredentialsException if wrong password
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        String token = jwtService.generateToken(user);
        return new AuthResponse(token, user.getEmail(), user.getFullName(),
                user.getRole().name(), user.getId());
    }
}
