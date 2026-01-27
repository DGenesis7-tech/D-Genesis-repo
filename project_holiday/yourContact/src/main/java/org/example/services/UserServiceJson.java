package org.example.services;

import org.example.data.models.Contact;
import org.example.data.models.User;
import org.example.data.repositories.UserRepository;
import org.example.dtos.requests.CreateContactRequest;
import org.example.dtos.requests.UpdateContactRequest;
import org.example.dtos.responses.ContactResponse;
import org.example.exceptions.UserNotFoundException;
import org.example.exceptions.ContactNotFoundException;
import org.example.utils.ValidationUtils;

import java.util.List;

public class UserServiceJson {

    private final UserRepository userRepository;

    public UserServiceJson(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(String fullName, String username, String email, int pin) {
        // Validate inputs
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new IllegalArgumentException("Full name cannot be empty");
        }
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }
        if (!ValidationUtils.isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email format");
        }
        if (!ValidationUtils.isValidPin(pin)) {
            throw new IllegalArgumentException("PIN must be 6 digits (100000-999999)");
        }

        // Check if username already exists
        User existingUser = userRepository.findByUsername(username);
        if (existingUser != null) {
            throw new IllegalArgumentException("Username already exists");
        }

        return userRepository.create(fullName, username, email, pin);
    }

    public User loginUser(String username, int pin) {
        User user = userRepository.findByUsername(username);
        if (user == null || user.getPin() != pin) return null;
        return user;
    }

    public User getUserById(int userId) {
        User user = userRepository.findById(userId);
        if (user == null) {
            throw new UserNotFoundException("User with ID " + userId + " not found");
        }
        return user;
    }

    public void createContact(User user, CreateContactRequest request) {
        // Validate contact inputs
        if (request.getName() == null || request.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Contact name cannot be empty");
        }
        if (request.getPhoneNumber() == null || request.getPhoneNumber().trim().isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be empty");
        }
        if (!ValidationUtils.isValidPhoneNumber(request.getPhoneNumber())) {
            throw new IllegalArgumentException("Invalid phone number format");
        }
        if (request.getEmail() != null && !request.getEmail().trim().isEmpty()
                && !ValidationUtils.isValidEmail(request.getEmail())) {
            throw new IllegalArgumentException("Invalid email format");
        }

        int newId = user.getContactList().getContacts().size() +
                user.getContactList().getTrash().size() + 1;
        Contact contact = new Contact(newId, request.getName(), request.getPhoneNumber(), request.getEmail());
        user.getContactList().addContact(contact);
    }

    public void updateContact(User user, UpdateContactRequest request) {
        Contact existing = user.getContactList().findById(request.getContactId());
        if (existing == null) throw new ContactNotFoundException("Contact not found");

        // Validate updated contact inputs
        if (request.getName() == null || request.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Contact name cannot be empty");
        }
        if (request.getPhoneNumber() == null || request.getPhoneNumber().trim().isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be empty");
        }
        if (!ValidationUtils.isValidPhoneNumber(request.getPhoneNumber())) {
            throw new IllegalArgumentException("Invalid phone number format");
        }
        if (request.getEmail() != null && !request.getEmail().trim().isEmpty()
                && !ValidationUtils.isValidEmail(request.getEmail())) {
            throw new IllegalArgumentException("Invalid email format");
        }

        existing.setName(request.getName());
        existing.setPhoneNumber(request.getPhoneNumber());
        existing.setEmail(request.getEmail());
    }

    public void deleteContact(User user, int contactId) {
        Contact existing = user.getContactList().findById(contactId);
        if (existing == null) throw new ContactNotFoundException("Contact not found");
        user.getContactList().removeContact(existing);
    }

    public void restoreContact(User user, int contactId) {
        Contact inTrash = user.getContactList().getTrash().stream()
                .filter(c -> c.getId() == contactId).findFirst().orElse(null);
        if (inTrash != null) user.getContactList().restoreFromTrash(inTrash);
    }

    public void sortAlphabetically(User user) { user.getContactList().sortAlphabetically(); }
    public void sortByLastAdded(User user) { user.getContactList().sortByLastAdded(); }

    public ContactResponse[] viewContacts(User user) {
        List<Contact> contacts = user.getContactList().getContacts();
        return contacts.stream()
                .map(c -> new ContactResponse(c.getId(), c.getName(), c.getPhoneNumber(), c.getEmail()))
                .toArray(ContactResponse[]::new);
    }

    public ContactResponse[] viewTrash(User user) {
        List<Contact> trash = user.getContactList().getTrash();
        return trash.stream()
                .map(c -> new ContactResponse(c.getId(), c.getName(), c.getPhoneNumber(), c.getEmail()))
                .toArray(ContactResponse[]::new);
    }
}
