import java.util.IllegalFormatCodePointException;
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
                2. Get Phonebook
                3. View all Phonebooks
                4. Delete Phonebook
                5. Exit
                ========================================
                
                Please select an option from 1-5 :""");
    }

    public void createPhoneBook(Scanner input) {
        this.phoneBook = new PhoneBook();
        System.out.println("Choose PhoneBook Name: ");
        String name = input.nextLine();
        this.phoneBook.setName(name);

        System.out.println("Enter Email Address: ");
        String email = input.nextLine();
        this.phoneBook.setEmail(email);

        System.out.println("Create unique ID: ");
        String id = input.nextLine();
        if (this.phoneBooks.isValidId(id)) {
            System.out.println("PhoneBook ID already exists! Please choose a different ID.");
            return;
        }
        this.phoneBooks.setPhoneBook(name, email, id);
        System.out.println("PhoneBook | " + name + " | | " + email + " | | " + id + " | created successfully.");
    }

    public void addContact(Scanner input) {
        System.out.println("Enter Contact Name: ");
        String name = input.nextLine();

        System.out.println("Enter Contact Email: ");
        String email = input.nextLine();

        System.out.println("Enter Contact Phone Number (10 digits) : ");
        long phoneNum = input.nextLong();
        boolean isNum = true;
        while (isNum) {
            if (phoneNum < 1000000000 || phoneNum > 9999999999L) {
                System.out.println("Invalid phone number. Please enter a number between 1 and 9999999999.");
                isNum = false;
            }
            else {
                System.out.println("Created successfully!");
            }
        }

        this.contact = new Contact(name, email, phoneNum);
        this.phoneBook.addContact(this.contact);
        System.out.println("Contact | " + name + " | | " + phoneNum + " | added successfully.");
    }

    public void displayContact(Scanner input) {
        System.out.println("Enter Contact Name: ");
        String name = input.nextLine();
        Contact contact = this.phoneBook.getContact(name);

        if (contact != null) {
            System.out.println(contact.getName() + " | | " + contact.getPhoneNum() + " | | " + contact.getEmail());
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
            System.out.println("| " + phoneBook1.getName() + " | | " + phoneBook1.getEmail() + " |");
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

    public void enterMyPhonebook(Scanner input) {
        System.out.println("Enter PhoneBook ID: ");
        String id = input.nextLine();

        if (phoneBooks.isValidId(id)) {
            phoneBooks.getPhoneBookById(id);
            System.out.println(" | " + phoneBook.getId() + " | | " + phoneBook.getName() + " | | " + phoneBook.getEmail() + " | ");
            System.out.println("1. View contacts");
            System.out.println("2. Get contact");
            System.out.println("3. Delete contact");
            System.out.println("4. Add contact");
            System.out.println("5. Exit");

            int option = 0;
            System.out.println("Select a number between 1 and 2");
            while (option == 4) {
                option = input.nextInt();

                switch (option) {
                    case 1:
                        this.viewContacts();
                        break;

                        case 2:
                            this.displayContact(input);
                            break;

                            case 3:
                                this.deleteContact(input);
                                break;

                                case 4:
                                    this.addContact(input);
                                    break;

                                    case 5:
                                        System.out.println("Exiting!!!");
                                    default:
                                        System.out.println("Invalid option");
                                        break;
                }


            }
        }

    }
}
