import java.util.ArrayList;
import java.util.List;

public class PhoneBooks {
    private List<PhoneBook> phoneBooks;

    public PhoneBooks() {
        this.phoneBooks = new ArrayList<>();
    }

    public boolean isValidId(String id) {
        for (PhoneBook phoneBook : phoneBooks) {
            if (phoneBook.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public void setPhoneBook(String name, String id, String email) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.setName(name);
        phoneBook.setId(id);
        phoneBook.setEmail(email);
        addPhoneBook(phoneBook);
    }

    public void addPhoneBook(PhoneBook phoneBook) {
        if (phoneBook != null) {
            this.phoneBooks.add(phoneBook);
        }
    }

    public List<PhoneBook> getPhoneBooks() {
        return phoneBooks;
    }

    public void deletePhoneBook(String id) {
        if (isValidId(id)) {
            for (PhoneBook phoneBook : phoneBooks) {
                if (phoneBook.getId().equals(id)) {
                    this.phoneBooks.remove(phoneBook);
                }
            }
        }
    }



}
