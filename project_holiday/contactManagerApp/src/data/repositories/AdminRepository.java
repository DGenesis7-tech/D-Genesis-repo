package src.data.repositories;

import src.data.models.Contact;
import src.data.models.Contacts;
import src.data.models.User;

import java.util.List;

public interface AdminRepository {
    void saveUser(User user);
    void deleteUser(User user);
    User findUserByUsername(String username);
    List<User> findAllUsers();
    int findUserById(int id);
    Contact findContactByFullName(String fullName);
    Contact findContactByPhoneNumber(String phoneNumber);
    Contact findContactByEmail(String email);
    Contacts findContactsByUsername(String username);
    List<Contact> findAllContacts();
}
