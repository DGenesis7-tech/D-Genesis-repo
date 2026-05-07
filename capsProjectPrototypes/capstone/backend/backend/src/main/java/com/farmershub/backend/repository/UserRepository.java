package com.farmershub.backend.repository;

import com.farmershub.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User>findByEmail(String email);

    boolean existsByEmail(String email);

    List<User> findByRole(com.farmershub.backend.model.Role role);
}
