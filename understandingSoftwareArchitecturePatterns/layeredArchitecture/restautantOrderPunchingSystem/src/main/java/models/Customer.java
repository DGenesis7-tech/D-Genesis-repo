package java.models;

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
    public String getName() { return name; }
    public String getEmail() { return email; }
    public double getBalance() { return balance; }

    public void fundWallet(double amount) {
        if (amount > 0) balance += amount;
    }

    public void deduct(double amount) {
        if (amount <= balance) balance -= amount;
        else throw new IllegalArgumentException("Insufficient balance");
    }
}