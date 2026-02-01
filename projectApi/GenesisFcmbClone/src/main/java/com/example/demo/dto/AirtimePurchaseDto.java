package com.example.demo.dto;

import com.example.demo.model.AirtimePurchase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AirtimePurchaseDto {
    private Long id;
    private Long userId;
    private String phoneNumber;
    private BigDecimal amount;
    private AirtimePurchase.AirtimeProvider provider;
    private AirtimePurchase.PurchaseStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
