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

        // Generate unique ID by finding the maximum existing ID and adding 1
        int maximumContactId = 0;
        for (Contact contact : user.getContactList().getContacts()) {
            if (contact.getId() > maximumContactId) {
                maximumContactId = contact.getId();
            }
        }
        for (Contact trashedContact : user.getContactList().getTrash()) {
            if (trashedContact.getId() > maximumContactId) {
                maximumContactId = trashedContact.getId();
            }
        }
        int newContactId = maximumContactId + 1;

        Contact newContact = new Contact(newContactId, request.getName(), request.getPhoneNumber(), request.getEmail());
        user.getContactList().addContact(newContact);
    }

    public void updateContact(User user, UpdateContactRequest request) {
        Contact existingContact = user.getContactList().findById(request.getContactId());
        if (existingContact == null) {
            throw new ContactNotFoundException("Contact not found");
        }

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

        existingContact.setName(request.getName());
        existingContact.setPhoneNumber(request.getPhoneNumber());
        existingContact.setEmail(request.getEmail());
    }

    public void deleteContact(User user, int contactId) {
        Contact existingContact = user.getContactList().findById(contactId);
        if (existingContact == null) {
            throw new ContactNotFoundException("Contact not found");
        }
        user.getContactList().removeContact(existingContact);
    }

    public void restoreContact(User user, int contactId) {
        Contact contactInTrash = null;
        for (Contact trashedContact : user.getContactList().getTrash()) {
            if (trashedContact.getId() == contactId) {
                contactInTrash = trashedContact;
                break;
            }
        }
        if (contactInTrash == null) {
            throw new ContactNotFoundException("Contact not found in trash");
        }
        user.getContactList().restoreFromTrash(contactInTrash);
    }

    public void sortAlphabetically(User user) {
        user.getContactList().sortAlphabetically();
    }

    public void sortByLastAdded(User user) {
        user.getContactList().sortByLastAdded();
    }

    public ContactResponse[] viewContacts(User user) {
        List<Contact> contactList = user.getContactList().getContacts();
        ContactResponse[] contactResponses = new ContactResponse[contactList.size()];
        for (int index = 0; index < contactList.size(); index++) {
            Contact contact = contactList.get(index);
            contactResponses[index] = new ContactResponse(contact.getId(), contact.getName(),
                    contact.getPhoneNumber(), contact.getEmail());
        }
        return contactResponses;
    }

    public ContactResponse[] viewTrash(User user) {
        List<Contact> trashList = user.getContactList().getTrash();
        ContactResponse[] trashResponses = new ContactResponse[trashList.size()];
        for (int index = 0; index < trashList.size(); index++) {
            Contact trashedContact = trashList.get(index);
            trashResponses[index] = new ContactResponse(trashedContact.getId(), trashedContact.getName(),
                    trashedContact.getPhoneNumber(), trashedContact.getEmail());
        }
        return trashResponses;
    }
}
