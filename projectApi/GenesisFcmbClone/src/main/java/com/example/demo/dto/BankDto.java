package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankDto {
    private Long id;
    private String name;
    private String code;
    private String adminEmail;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
