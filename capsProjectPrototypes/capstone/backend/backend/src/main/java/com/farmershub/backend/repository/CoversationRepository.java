package com.farmershub.backend.repository;

import com.farmershub.backend.model.Conversation;
import com.farmershub.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CoversationRepository extends JpaRepository<Conversation, Long> {

    @Query("SELECT c FROM Conversation c WHERE c.user1 = :user OR c.user2 = :user ORDER BY c.updatedAt DESC")
    List<Conversation> findByUser(User user);

    @Query("SELECT c FROM Conversation c WHERE (c.user1 = :u1 AND c.user2 = :u2) OR (c.user1 = :u2 AND c.user2 = :u1)")
    Optional<Conversation> findBetweenUsers(User u1, User u2);

}
