package org.example.data.models;

import java.util.ArrayList;
import java.util.List;

public class ContactList {
    private List<Contact> contacts;
    private List<Contact> trash;

    public ContactList() {
        this.contacts = new ArrayList<>();
        this.trash = new ArrayList<>();
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public List<Contact> getTrash() {
        return trash;
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void removeContact(Contact contact) {
        contacts.remove(contact);
        trash.add(contact);
    }

    public void restoreFromTrash(Contact contact) {
        trash.remove(contact);
        contacts.add(contact);
    }

    public Contact findById(int contactId) {
        for (Contact contact : contacts) {
            if (contact.getId() == contactId) {
                return contact;
            }
        }
        return null;
    }

    public void sortAlphabetically() {
        for (int index = 0; index < contacts.size() - 1; index++) {
            for (int index2 = 0; index2 < contacts.size() - index - 1; index2++) {
                Contact currentContact = contacts.get(index2);
                Contact nextContact = contacts.get(index2 + 1);
                if (isGreaterThan(currentContact.getName(), nextContact.getName())) {
                    contacts.set(index2, nextContact);
                    contacts.set(index2 + 1, currentContact);
                }
            }
        }
    }

    private boolean isGreaterThan(String name1, String name2) {
        String lowerName1 = name1.toLowerCase();
        String lowerName2 = name2.toLowerCase();
        int length1 = lowerName1.length();
        int length2 = lowerName2.length();
        int smallerLength = length1;
        if (length2 < length1) {
            smallerLength = length2;
        }

        for (int index = 0; index < smallerLength; index++) {
            char char1 = lowerName1.charAt(index);
            char char2 = lowerName2.charAt(index);
            if (char1 > char2) {
                return true;
            } else if (char1 < char2) {
                return false;
            }
        }

        if (length1 > length2) {
            return true;
        } else {
            return false;
        }
    }

    public void sortByLastAdded() {
        for (int index = 0; index < contacts.size() - 1; index++) {
            for (int index1 = 0; index1 < contacts.size() - index - 1; index1++) {
                Contact currentContact = contacts.get(index1);
                Contact nextContact = contacts.get(index1 + 1);
                if (currentContact.getId() > nextContact.getId()) {
                    contacts.set(index1, nextContact);
                    contacts.set(index1 + 1, currentContact);
                }
            }
        }
    }
}
