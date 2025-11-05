import java.util.ArrayList;
import java.util.Scanner;

public class MainTest {
    public void main(String[] args) {
        UseClass run = new UseClass();
        Scanner input = new Scanner(System.in);
        run.displayHomepage();
        run.createPhoneBook(input);
        run.viewPhonebooksList();
        run.deletePhonebook(input);

    }

}

