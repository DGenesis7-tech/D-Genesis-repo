package model;

public class SavingsRule {

    public double calculateSavings(Transaction transaction) {
        if (transaction.getType() == TransactionType.INCOME && transaction.getSource() == TransactionSource.WHATSAPP) {
            return transaction.getAmount() * 0.10;
        }
        return 0.0;
    }
}
