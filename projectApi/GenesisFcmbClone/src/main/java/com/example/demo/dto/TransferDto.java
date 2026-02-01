package com.example.demo.dto;

import com.example.demo.model.Transfer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferDto {
    private Long id;
    private Long senderId;
    private String senderName;
    private String recipientAccountNumber;
    private BigDecimal amount;
    private String description;
    private Transfer.TransferStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
