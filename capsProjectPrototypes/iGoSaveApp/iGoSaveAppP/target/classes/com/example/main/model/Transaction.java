package model;

import java.time.LocalDateTime;

public class Transaction {

    private TransactionType type;
    private TransactionSource source;
    private double amount;
    private LocalDateTime timestamp;

    public Transaction(TransactionType type, TransactionSource source, double amount, LocalDateTime timestamp) {
        this.type = type;
        this.source = source;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    public TransactionType getType() {
        return type;
    }

    public TransactionSource getSource() {
        return source;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public double getAmount() {
        return amount;
    }

}
