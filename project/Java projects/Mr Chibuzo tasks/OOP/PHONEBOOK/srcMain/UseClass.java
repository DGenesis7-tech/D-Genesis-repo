import java.util.Scanner;

public class UseClass {
    private PhoneBooks phoneBooks;
    private PhoneBook phoneBook;
    private Contact contact;

    public UseClass() {
        this.phoneBooks = new PhoneBooks();
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
                6. View contact
                7. Delete contact
                8. Exit
                ========================================
                
                Please select an option from 1-8 :""");
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
        Contact contact = this.phoneBook.getContact(name);

        if (contact != null) {
            System.out.println(contact.toString());
        }
        else {
            System.out.println("Contact not found");
        }
    }

    public void deleteContact(Scanner input) {
        System.out.println("Enter Contact Name: ");
        String name = input.nextLine();
        this.phoneBook.deleteContact(name);
    }

    public void viewContacts() {
        if (this.phoneBook != null) {
            System.out.println("Viewing Contacts for PhoneBook |" + this.phoneBook.getName() + "| ");
            for (Contact contact : phoneBook.getContactsList()) {
                System.out.println(contact.toString());
            }
        }
        else {
            System.out.println("Phone Book not found");
        }
    }

    public void viewPhonebooksList() {
        System.out.println("Viewing All Phonebooks: ");
        for (PhoneBook phoneBook1 : phoneBooks.getPhoneBooks()) {
            System.out.println(phoneBook1.toString());
        }
    }

    public void deletePhonebook(Scanner input) {
        System.out.println("Enter PhoneBook ID: ");
        String id = input.nextLine();
        if (phoneBooks.isValidId(id)) {
            phoneBooks.deletePhoneBook(id);
            System.out.println(id + "Phone Book has been deleted successfully");
        }
        else {
            System.out.println("Phone Book ID not found");
        }
    }

}
