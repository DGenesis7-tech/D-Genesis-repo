package org.example.data.models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactList {
    private List<Contact> contacts;
    private List<Contact> trash;

    public ContactList() {
        this.contacts = new ArrayList<>();
        this.trash = new ArrayList<>();
    }

    public List<Contact> getContacts() { return contacts; }
    public List<Contact> getTrash() { return trash; }

    public void addContact(Contact contact) { contacts.add(contact); }

    public void removeContact(Contact contact) {
        contacts.remove(contact);
        trash.add(contact);
    }

    public void restoreFromTrash(Contact contact) {
        trash.remove(contact);
        contacts.add(contact);
    }

    public Contact findById(int contactId) {
        return contacts.stream().filter(c -> c.getId() == contactId).findFirst().orElse(null);
    }

    public void updateContact(Contact contact) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getId() == contact.getId()) {
                contacts.set(i, contact);
            }
        }
    }

    public void sortAlphabetically() {
        contacts.sort(Comparator.comparing(Contact::getName));
    }

    public void sortByLastAdded() {
        contacts.sort(Comparator.comparing(Contact::getId));
    }
}
