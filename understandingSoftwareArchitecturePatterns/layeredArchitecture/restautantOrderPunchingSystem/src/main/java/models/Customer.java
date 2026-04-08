package models;

public class Customer {
    private String id;
    private String name;
    private String email;
    private double balance;

    public Customer(String id, String name, String email, double balance) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.balance = balance;
    }

    public String getId() { return id; }
    public double getBalance() { return balance; }

    public void deduct(double amount) {
        if (amount > balance) throw new IllegalArgumentException("Insufficient balance");
        balance -= amount;
    }
}