package com.farmershub.backend.repository;

import com.farmershub.backend.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    // Get all messages in a conversation, ordered by time
    List<Message> findByConversationIdOrderBySentAtAsc(Long conversationId);
}