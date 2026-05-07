package com.farmershub.backend.controller;

import com.farmershub.backend.model.Conversation;
import com.farmershub.backend.model.Message;
import com.farmershub.backend.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/conversations")
@RequiredArgsConstructor
public class ConversationController {

    private final ConversationService conversationService;
    private final MessageService messageService;

    // Get or start conversation between two users
    @GetMapping("/between/{user1Id}/{user2Id}")
    public ResponseEntity<Conversation> getOrCreate(
            @PathVariable Long user1Id, @PathVariable Long user2Id) {
        return ResponseEntity.ok(conversationService.getOrCreate(user1Id, user2Id));
    }

    // Get all conversations for a user (for the sidebar)
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Conversation>> getUserConversations(@PathVariable Long userId) {
        return ResponseEntity.ok(conversationService.getUserConversations(userId));
    }

    // Get all messages in a conversation
    @GetMapping("/{conversationId}/messages")
    public ResponseEntity<List<Message>> getMessages(@PathVariable Long conversationId) {
        return ResponseEntity.ok(messageService.getMessages(conversationId));
    }
}
