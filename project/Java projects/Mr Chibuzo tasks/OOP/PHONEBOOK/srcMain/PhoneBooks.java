import java.util.ArrayList;
import java.util.List;

public class PhoneBooks {
    private PhoneBook phoneBook;
    private List<PhoneBook> phoneBooks;

    public PhoneBooks(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
        this.phoneBooks = new ArrayList<>();
    }

    public PhoneBook getPhoneBook() {
        return phoneBook;
    }

    public void setPhoneBook(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    public void addPhoneBook() {
        this.phoneBooks.add(phoneBook);
    }

}
