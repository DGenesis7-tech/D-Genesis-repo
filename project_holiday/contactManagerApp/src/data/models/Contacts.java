package src.data.models;

import java.util.ArrayList;

public class Contacts {
    private Contact contact;
    private ArrayList<Contact> contacts;

    public Contacts() {}

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
