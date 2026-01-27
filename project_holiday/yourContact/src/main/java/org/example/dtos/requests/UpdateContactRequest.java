package org.example.dtos.requests;

public class UpdateContactRequest extends CreateContactRequest {
    private int contactId;

    public UpdateContactRequest(int contactId, String name, String phoneNumber, String email) {
        super(name, phoneNumber, email);
        this.contactId = contactId;
    }

    public int getContactId() { return contactId; }
}
