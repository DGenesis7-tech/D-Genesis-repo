package org.example.controllers;

import org.example.services.UserServiceJson;
import org.example.data.models.User;
import org.example.dtos.requests.CreateContactRequest;
import org.example.dtos.requests.UpdateContactRequest;
import org.example.dtos.responses.ContactResponse;
import org.example.exceptions.ContactNotFoundException;
import org.example.utils.MapUtils;

import java.util.Map;

public class UserControllerJson {

    private final UserServiceJson userService;

    public UserControllerJson(UserServiceJson userService) {
        this.userService = userService;
    }

    public String register(String jsonInput) {
        Map<String, Object> map = MapUtils.jsonToMap(jsonInput);
        String fullName = MapUtils.getString(map, "fullName");
        String username = MapUtils.getString(map, "username");
        String email = MapUtils.getString(map, "email");
        int pin = MapUtils.getInt(map, "pin");

        User user = userService.registerUser(fullName, username, email, pin);

        return MapUtils.mapToJson(Map.of("id", user.getId(), "fullName", user.getFullName()));
    }

    public String login(String jsonInput) {
        Map<String, Object> map = MapUtils.jsonToMap(jsonInput);
        String username = MapUtils.getString(map, "username");
        int pin = MapUtils.getInt(map, "pin");

        User user = userService.loginUser(username, pin);
        if (user == null) return MapUtils.mapToJson(Map.of("error", "Invalid credentials"));

        return MapUtils.mapToJson(Map.of("id", user.getId(), "fullName", user.getFullName()));
    }

    public String createContact(String userId, String jsonInput) {
        User user = getUserById(userId);
        Map<String, Object> map = MapUtils.jsonToMap(jsonInput);
        try {
            userService.createContact(user,
                    new CreateContactRequest(
                            MapUtils.getString(map, "name"),
                            MapUtils.getString(map, "phoneNumber"),
                            MapUtils.getString(map, "email")));
            return MapUtils.mapToJson(Map.of("message", "Contact created successfully"));
        } catch (IllegalArgumentException e) {
            return MapUtils.mapToJson(Map.of("error", e.getMessage()));
        }
    }

    public String updateContact(String userId, String jsonInput) {
        User user = getUserById(userId);
        Map<String, Object> map = MapUtils.jsonToMap(jsonInput);
        try {
            userService.updateContact(user,
                    new UpdateContactRequest(
                            MapUtils.getInt(map, "contactId"),
                            MapUtils.getString(map, "name"),
                            MapUtils.getString(map, "phoneNumber"),
                            MapUtils.getString(map, "email")));
            return MapUtils.mapToJson(Map.of("message", "Contact updated successfully"));
        } catch (IllegalArgumentException | ContactNotFoundException e) {
            return MapUtils.mapToJson(Map.of("error", e.getMessage()));
        }
    }

    public String deleteContact(String userId, int contactId) {
        User user = getUserById(userId);
        try {
            userService.deleteContact(user, contactId);
            return MapUtils.mapToJson(Map.of("message", "Contact deleted (moved to trash)"));
        } catch (ContactNotFoundException e) {
            return MapUtils.mapToJson(Map.of("error", e.getMessage()));
        }
    }

    public String restoreContact(String userId, int contactId) {
        User user = getUserById(userId);
        userService.restoreContact(user, contactId);
        return MapUtils.mapToJson(Map.of("message", "Contact restored from trash"));
    }

    public String sortContactsAlphabetically(String userId) {
        User user = getUserById(userId);
        userService.sortAlphabetically(user);
        return MapUtils.mapToJson(Map.of("message", "Contacts sorted alphabetically"));
    }

    public String sortContactsByLastAdded(String userId) {
        User user = getUserById(userId);
        userService.sortByLastAdded(user);
        return MapUtils.mapToJson(Map.of("message", "Contacts sorted by last added"));
    }

    public String viewContacts(String userId) {
        User user = getUserById(userId);
        ContactResponse[] contacts = userService.viewContacts(user);
        return MapUtils.mapToJson(Map.of("contacts", contacts));
    }

    public String viewTrash(String userId) {
        User user = getUserById(userId);
        ContactResponse[] trash = userService.viewTrash(user);
        return MapUtils.mapToJson(Map.of("trash", trash));
    }

    private User getUserById(String userId) {
        return userService.loginUser(userService.registerUser("", "", "", 0).getUsername(), 0); // replace with actual lookup
    }
}
