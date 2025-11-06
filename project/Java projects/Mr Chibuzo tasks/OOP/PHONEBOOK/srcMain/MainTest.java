import java.util.ArrayList;
import java.util.Scanner;

public class MainTest {
    public void main(String[] args) {
       Scanner input = new Scanner(System.in);
       UseClass useClass = new UseClass();

       while(true){
            useClass.displayHomepage();
            int choice = input.nextInt();
            input.nextLine();

            switch (choice){
                case 1:
                    useClass.createPhoneBook(input);
                    break;
                case 2:
                    useClass.addContact(input);
                    break;
                case 3:
                    useClass.viewContacts();
                    break;
                case 4:
                    useClass.viewPhonebooksList();
                    break;
                case 5:
                    useClass.deletePhonebook(input);
                    break;
                case 6:
                    useClass.displayContact(input);
                    break;
                case 7:
                    useClass.deleteContact(input);
                case 8:
                    System.out.println("Exiting :::");
                    break;
                default:
                    System.out.println("Invalid choice. Try again");
            }
       }
    }

}

