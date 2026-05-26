package com.farmershub.backend.controller;

import com.farmershub.backend.dto.MessageDTO;
import com.farmershub.backend.model.Message;
import com.farmershub.backend.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ChatWebSocketController {

    private final MessageService messageService;
    private final SimpMessagingTemplate messagingTemplate;

    // Client sends message to /app/chat.send
    @MessageMapping("/chat.send")
    public void sendMessage(@Payload MessageDTO messageDTO) {
        Message saved = messageService.sendMessage(messageDTO);

        // Broadcast to everyone subscribed to /topic/conversation/{id}
        messagingTemplate.convertAndSend(
                "/topic/conversation/" + messageDTO.getConversationId(),
                saved
        );
    }
}
