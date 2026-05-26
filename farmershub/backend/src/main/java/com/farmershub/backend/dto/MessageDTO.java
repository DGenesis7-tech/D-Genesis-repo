package com.farmershub.backend.dto;

import lombok.Data;

@Data
public class MessageDTO {
    private Long conversationId;  // which conversation
    private Long senderId;
    private String content;
}
