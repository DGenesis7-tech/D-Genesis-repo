package com.example.demo.dto;

import com.example.demo.model.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * DTO for login response
 * Returns user details + token (for future JWT implementation)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDto {
    private Long id;
    private Long bankId;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String accountNumber;
    private BigDecimal accountBalance;
    private UserRole role;
    private String token;  // Will contain JWT token in future
    private LocalDateTime loginTime;
    private String message;
}
