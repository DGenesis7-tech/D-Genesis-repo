import java.util.ArrayList;
import java.util.List;

public class PhoneBooks {
    private PhoneBook phoneBook;
    private List<PhoneBook> phoneBooks;
    private ArrayList<Contact> contacts;

    public PhoneBooks(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
        this.phoneBooks = new ArrayList<>();
    }

    public boolean isValidId(String id) {
        if (phoneBook.getId().equals(id)) {
            return true;
        } else {
            System.out.println("INVALID PHONEBOOK ID");
        }
        return false;
    }

    public PhoneBook getPhoneBook(String id) {
        do {
            if (isValidId(id)) {
                return this.phoneBook;
            }
        } while (isValidId(id));
        return null;
    }

    public void setPhoneBook(String name, String id, String email) {
        this.phoneBook = new PhoneBook();
        phoneBook.setName(name);
        phoneBook.setId(id);
        phoneBook.setEmail(email);
        addPhoneBook();
    }

    public void addPhoneBook() {
        this.phoneBooks.add(phoneBook);
    }

    public List<PhoneBook> getPhoneBooks() {
        return phoneBooks;
    }

    public void deletePhoneBook(String id) {
        if (isValidId(id)) {
            this.phoneBooks.remove(phoneBook);
        }
    }

}
