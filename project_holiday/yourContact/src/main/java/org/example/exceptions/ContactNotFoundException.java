package org.example.exceptions;

public class ContactNotFoundException extends RuntimeException{
    public ContactNotFoundException(String username) {
        super("Contact not found");
    }
}
