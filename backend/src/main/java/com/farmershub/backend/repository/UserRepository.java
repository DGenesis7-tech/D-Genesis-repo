package com.farmershub.backend.repository;

import com.farmershub.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    // Spring generates: SELECT * FROM users WHERE email = ?
    Optional<User> findByEmail(String email);

    // Check if email already exists
    boolean existsByEmail(String email);

    // Find all users that are not admin (for the contact list)
    List<User> findByRoleNot(com.farmershub.backend.model.Role role);
}