package com.farmershub.backend.service;

import com.farmershub.backend.model.Conversation;
import com.farmershub.backend.model.User;
import com.farmershub.backend.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConversationService {

    private final ConversationRepository conversationRepository;
    private final UserRepository userRepository;

    // Get or create a conversation between two users
    public Conversation getOrCreate(Long user1Id, Long user2Id) {
        User u1 = userRepository.findById(user1Id).orElseThrow();
        User u2 = userRepository.findById(user2Id).orElseThrow();

        return conversationRepository.findBetweenUsers(u1, u2)
                .orElseGet(() -> conversationRepository.save(
                        Conversation.builder().user1(u1).user2(u2).build()
                ));
    }

    public List<Conversation> getUserConversations(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        return conversationRepository.findByUser(user);
    }
}
