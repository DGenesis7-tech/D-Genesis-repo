package org.example.data.models;

public class User {
    private int id;
    private String fullName;
    private String username;
    private String email;
    private int pin;
    private ContactList contactList;

    public User(int id, String fullName, String username, String email, int pin) {
        this.id = id;
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.pin = pin;
        this.contactList = new ContactList();
    }

    public int getId() { return id; }
    public String getFullName() { return fullName; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public int getPin() { return pin; }
    public ContactList getContactList() { return contactList; }
}
