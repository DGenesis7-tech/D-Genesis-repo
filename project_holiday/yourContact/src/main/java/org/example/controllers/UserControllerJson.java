package org.example.controllers;

import org.example.services.UserServiceJson;
import org.example.data.models.User;
import org.example.dtos.requests.CreateContactRequest;
import org.example.dtos.requests.UpdateContactRequest;
import org.example.dtos.responses.ContactResponse;
import org.example.exceptions.ContactNotFoundException;
import org.example.utils.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserControllerJson {

    private final UserServiceJson userService;
    private User currentUser;

    @Autowired
    public UserControllerJson(UserServiceJson userService) {
        this.userService = userService;
        this.currentUser = null;
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> register(@RequestBody Map<String, Object> requestBody) {
        String fullName = (String) requestBody.get("fullName");
        String username = (String) requestBody.get("username");
        String email = (String) requestBody.get("email");
        Object pinObject = requestBody.get("pin");
        int pin = 0;
        if (pinObject instanceof Double) {
            Double pinDouble = (Double) pinObject;
            pin = pinDouble.intValue();
        } else if (pinObject instanceof Integer) {
            pin = (Integer) pinObject;
        }

        try {
            User user = userService.registerUser(fullName, username, email, pin);
            this.currentUser = user;

            Map<String, Object> response = new HashMap<>();
            response.put("id", user.getId());
            response.put("fullName", user.getFullName());
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, Object> requestBody) {
        String username = (String) requestBody.get("username");
        Object pinObject = requestBody.get("pin");
        int pin = 0;
        if (pinObject instanceof Double) {
            Double pinDouble = (Double) pinObject;
            pin = pinDouble.intValue();
        } else if (pinObject instanceof Integer) {
            pin = (Integer) pinObject;
        }

        User user = userService.loginUser(username, pin);
        if (user == null) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Invalid credentials");
            return ResponseEntity.badRequest().body(errorResponse);
        }

        this.currentUser = user;
        Map<String, Object> response = new HashMap<>();
        response.put("id", user.getId());
        response.put("fullName", user.getFullName());
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/users/{userId}/contacts")
    public ResponseEntity<?> createContact(@PathVariable String userId, @RequestBody Map<String, Object> body) {
        User user = getUserById(userId);
        try {
            userService.createContact(user,
                    new CreateContactRequest(
                            MapUtils.getString(body, "name"),
                            MapUtils.getString(body, "phoneNumber"),
                            MapUtils.getString(body, "email")));
            return ResponseEntity.ok(Map.of("message", "Contact created successfully"));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @PutMapping(value = "/users/{userId}/contacts/{contactId}")
    public ResponseEntity<?> updateContact(@PathVariable String userId, @PathVariable int contactId, @RequestBody Map<String, Object> body) {
        User user = getUserById(userId);
        try {
            userService.updateContact(user,
                    new UpdateContactRequest(
                            contactId,
                            MapUtils.getString(body, "name"),
                            MapUtils.getString(body, "phoneNumber"),
                            MapUtils.getString(body, "email")));
            return ResponseEntity.ok(Map.of("message", "Contact updated successfully"));
        } catch (IllegalArgumentException | ContactNotFoundException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @DeleteMapping(value = "/users/{userId}/contacts/{contactId}")
    public ResponseEntity<?> deleteContact(@PathVariable String userId, @PathVariable int contactId) {
        User user = getUserById(userId);
        try {
            userService.deleteContact(user, contactId);
            return ResponseEntity.ok(Map.of("message", "Contact deleted (moved to trash)"));
        } catch (ContactNotFoundException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @PostMapping(value = "/users/{userId}/contacts/{contactId}/restore")
    public ResponseEntity<?> restoreContact(@PathVariable String userId, @PathVariable int contactId) {
        User user = getUserById(userId);
        try {
            userService.restoreContact(user, contactId);
            return ResponseEntity.ok(Map.of("message", "Contact restored from trash"));
        } catch (ContactNotFoundException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @PostMapping("/users/{userId}/contacts/sort/alphabetical")
    public ResponseEntity<?> sortContactsAlphabetically(@PathVariable String userId) {
        User user = getUserById(userId);
        userService.sortAlphabetically(user);
        return ResponseEntity.ok(Map.of("message", "Contacts sorted alphabetically"));
    }

    @PostMapping("/users/{userId}/contacts/sort/last-added")
    public ResponseEntity<?> sortContactsByLastAdded(@PathVariable String userId) {
        User user = getUserById(userId);
        userService.sortByLastAdded(user);
        return ResponseEntity.ok(Map.of("message", "Contacts sorted by last added"));
    }

    @GetMapping("/users/{userId}/contacts")
    public ResponseEntity<?> viewContacts(@PathVariable String userId) {
        User user = getUserById(userId);
        ContactResponse[] contacts = userService.viewContacts(user);
        return ResponseEntity.ok(Map.of("contacts", contacts));
    }

    @GetMapping("/users/{userId}/contacts/trash")
    public ResponseEntity<?> viewTrash(@PathVariable String userId) {
        User user = getUserById(userId);
        ContactResponse[] trash = userService.viewTrash(user);
        return ResponseEntity.ok(Map.of("trash", trash));
    }

    // java
    private User getUserById(String userId) {
        // minimal current-user lookup: use logged-in user if it matches the requested id
        if (this.currentUser != null && String.valueOf(this.currentUser.getId()).equals(userId)) {
            return this.currentUser;
        }
        throw new IllegalArgumentException("User not found or not logged in. Please login first.");
    }

}
