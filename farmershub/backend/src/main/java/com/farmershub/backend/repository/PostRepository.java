package com.farmershub.backend.repository;

import com.farmershub.backend.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    // Get all posts by a specific user, newest first
    List<Post> findByUserIdOrderByCreatedAtDesc(Long userId);

    Page<Post> findByAvailableTrue(Pageable pageable);

    Page<Post> findByCategoryAndAvailableTrue(String category, Pageable pageable);
}