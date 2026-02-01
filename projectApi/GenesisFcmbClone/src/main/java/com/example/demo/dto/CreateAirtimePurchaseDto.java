package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAirtimePurchaseDto {
    private Long userId;
    private String phoneNumber;
    private BigDecimal amount;
    private String provider;
}
