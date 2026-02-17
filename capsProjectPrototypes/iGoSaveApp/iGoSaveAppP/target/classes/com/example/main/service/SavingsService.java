package service;

import model.SavingsAccount;
import model.SavingsRecord;
import repository.SavingsRecordRepository;

public class SavingsService {

    private final SavingsAccount savingsAccount;
    private final SavingsRecordRepository repository;
    private SavingsRecord savingsRecord;

    public SavingsService(SavingsAccount savingsAccount, SavingsRecordRepository repository) {
        this.savingsAccount = savingsAccount;
        this.repository = repository;
        this.savingsRecord = record;
    }

    private void save(String planType, double amount, int duration) {
        if (amount > 0 && duration > 0) {

            double total = amount * duration;

            savingsAccount.addSavedAmount(total);

            repository.save(this.savingsRecord);
        }
    }

    public void saveDaily(double amount, int days) {
        save("DAILY", amount, days);
    }

    public void saveWeekly(double amount, int weeks) {
        save("WEEKLY", amount, weeks);
    }

    public void saveMonthly(double amount, int months) {
        save("MONTHLY", amount, months);
    }
}
