import java.util.ArrayList;
import java.util.Scanner;

public class MainTest {
    public void main(String[] args) {
       Scanner input = new Scanner(System.in);
       UseClass useClass = new UseClass();
        int choice = 0;
        while(choice != 5){
            useClass.displayHomepage();
            choice = input.nextInt();
            input.nextLine();

            switch (choice){
                case 1:
                    useClass.createPhoneBook(input);
                    break;
                case 2:
                    useClass.enterMyPhonebook(input);
                    break;
                case 3:
                    useClass.viewPhonebooksList();
                    break;
                case 4:
                    useClass.deletePhonebook(input);
                    break;
                case 5:
                    System.out.println("Exiting :::");
                    break;
                default:
                    System.out.println("Invalid choice. Try again");
            }
       }
    }

}

