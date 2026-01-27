package org.example.dtos.requests;

public class CreateContactRequest {
    private String name;
    private String phoneNumber;
    private String email;

    public CreateContactRequest(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() { return name; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getEmail() { return email; }
}
