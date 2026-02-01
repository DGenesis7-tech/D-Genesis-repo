package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDto {
    private Long bankId;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String password;
    private String pin;              // 6-digit PIN for banking transactions
    private String role; // "ADMIN" or "USER"
}
