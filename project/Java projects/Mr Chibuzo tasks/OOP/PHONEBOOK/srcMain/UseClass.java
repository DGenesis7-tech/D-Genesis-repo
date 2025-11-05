import java.util.Scanner;

public class UseClass {
    private PhoneBooks phoneBooks;
    private PhoneBook phoneBook;
    private Contact contact;

    public UseClass() {
    }

    public void displayHomepage() {
        System.out.println("""
                ======================================
                Welcome to Genesis Phonebook console ||
                ======================================
                1. Create PhoneBook
                2. Add Contact
                3. View myContacts
                4. View all Phonebooks
                5. Delete Phonebook
                6. Delete Contact
                7. Exit
                ========================================
                """);
    }

    public void createPhoneBook(Scanner input) {
        this.phoneBook = new PhoneBook();
        System.out.println("Choose PhoneBook Name: ");
        String name = input.nextLine();
        this.phoneBook.setName(name);
        System.out.println("Enter Email Address: ");
        String email = input.nextLine();
        this.phoneBook.setEmail(email);
        System.out.println("Enter ID: ");
        String id = input.nextLine();
        this.phoneBook.setId(id);
        this.phoneBooks.setPhoneBook(name, email, id);
        this.phoneBooks.addPhoneBook();
    }

    public void addContact(Scanner input) {
        System.out.println("Enter Contact Name: ");
        String name = input.nextLine();
        System.out.println("Enter Contact Email: ");
        String email = input.nextLine();
        System.out.println("Enter Phone Number: ");
        String phoneNum = input.nextLine();
        this.contact = new Contact(name, phoneNum, email);
        this.phoneBook.addContact(this.contact);
    }

    public void displayContact(Scanner input) {
        System.out.println("Enter Contact Name: ");
        String name = input.nextLine();
        Contact contact1 = this.phoneBook.getContact(name);
        System.out.println(contact1.toString());
    }

    public void deleteContact(Scanner input) {
        System.out.println("Enter Contact Name: ");
        String name = input.nextLine();
        this.phoneBook.deleteContact(name);
    }

    public void viewContacts() {
        this.phoneBooks.isValidId(phoneBook.getId());
        System.out.println(this.phoneBook.getContactsList());
    }

    public void viewPhonebooksList() {
        System.out.println(this.phoneBooks.getPhoneBooks());
    }

    public void deletePhonebook(Scanner input) {
        System.out.println("Enter ID: ");
        String id = input.nextLine();
        if (phoneBook.getId().equals(id)) {
            phoneBooks.deletePhoneBook(phoneBook.getId());
        }
    }


}
