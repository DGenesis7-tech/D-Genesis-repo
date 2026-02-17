import model.SavingsAccount;
import repository.SavingsRecordRepository;
import repository.SavingsRecordRepositoryImpl;
import service.SavingsService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        SavingsRecordRepository repository =
                new SavingsRecordRepositoryImpl();

        SavingsAccount savingsAccount = new SavingsAccount();

               repository.findAll().forEach(record ->
                savingsAccount.addSavedAmount(record.getTotalSaved())
        );

        SavingsService savingsService =
                new SavingsService(savingsAccount, repository);

        System.out.println("Welcome to I Go Save App!");

        while (true) {

            System.out.println("""
                    Choose an option:
                    1. Save Daily
                    2. Save Weekly
                    3. Save Monthly
                    4. View Savings History
                    5. Exit
                    """);

            int choice = scanner.nextInt();

            switch (choice) {

                case 1, 2, 3 -> {
                    System.out.print("Enter amount to save (₦): ");
                    double amount = scanner.nextDouble();

                    System.out.print("Enter duration: ");
                    int duration = scanner.nextInt();

                    if (choice == 1)
                        savingsService.saveDaily(amount, duration);
                    else if (choice == 2)
                        savingsService.saveWeekly(amount, duration);
                    else
                        savingsService.saveMonthly(amount, duration);

                    System.out.println(
                            "Total lifetime savings: ₦"
                                    + savingsAccount.getTotalSaved()
                    );
                }

                case 4 -> {
                    System.out.println("\nSavings History:");
                    repository.findAll().forEach(record ->
                            System.out.println(
                                    record.getPlanType() +
                                            " | Amount: ₦" + record.getAmount() +
                                            " | Duration: " + record.getDuration() +
                                            " | Total: ₦" + record.getTotalSaved()
                            )
                    );
                }

                case 5 -> {
                    System.out.println("Thank you for using I Go Save App!");
                    break;
                }

                default -> System.out.println("Invalid choice!");
            }

            if (choice == 5) break;
        }
    }
}
