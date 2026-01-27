package org.example.dtos.responses;

public class ContactResponse {
    private int id;
    private String name;
    private String phoneNumber;
    private String email;

    public ContactResponse(int id, String name, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getEmail() { return email; }
}
