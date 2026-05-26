package com.farmershub.backend.service;

import com.farmershub.backend.dto.MessageDTO;
import com.farmershub.backend.model.Conversation;
import com.farmershub.backend.model.Message;
import com.farmershub.backend.model.User;
import com.farmershub.backend.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;
    private final ConversationRepository conversationRepository;
    private final UserRepository userRepository;

    public Message sendMessage(MessageDTO dto) {
        Conversation conversation = conversationRepository.findById(dto.getConversationId())
                .orElseThrow(() -> new RuntimeException("Conversation not found"));

        User sender = userRepository.findById(dto.getSenderId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Message message = Message.builder()
                .conversation(conversation)
                .sender(sender)
                .content(dto.getContent())
                .sentAt(LocalDateTime.now())
                .build();

        // Update conversation's last activity time
        conversation.setUpdatedAt(LocalDateTime.now());
        conversationRepository.save(conversation);

        return messageRepository.save(message);
    }

    public List<Message> getMessages(Long conversationId) {
        return messageRepository.findByConversationIdOrderBySentAtAsc(conversationId);
    }
}
