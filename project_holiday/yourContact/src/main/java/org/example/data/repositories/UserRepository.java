package org.example.data.repositories;

import org.example.data.models.User;

public interface UserRepository {

    User create(String fullName, String username, String email, int pin);

    User findById(int id);

    User findByUsername(String username);
}
