package org.example.data.repositories;

import org.example.data.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private final List<User> users = new ArrayList<>();
    private int lastUserId = 0;

    public User create(String fullName, String username, String email, int pin) {
        lastUserId++;
        User user = new User(lastUserId, fullName, username, email, pin);
        users.add(user);
        return user;
    }

    public User findById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User findByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
}
