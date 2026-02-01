package com.example.demo.dto;

import com.example.demo.model.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private Long bankId;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String accountNumber;
    private BigDecimal accountBalance;
    private UserRole role;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
