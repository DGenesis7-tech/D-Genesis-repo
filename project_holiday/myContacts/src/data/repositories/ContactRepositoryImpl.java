package repositories;

import models.Contact;
import java.util.ArrayList;
import java.util.List;

public class ContactRepositoryImpl implements ContactRepository {

    private List<Contact> contacts = new ArrayList<>();

    public void save(Contact contact) {
        contacts.add(contact);
    }

    public List<Contact> findAll() {
        return contacts;
    }

    public Contact findById(int id) {
        for (Contact c : contacts) {
            if (c.getId() == id) return c;
        }
        return null;
    }

    public void delete(Contact contact) {
        contacts.remove(contact);
    }
}
