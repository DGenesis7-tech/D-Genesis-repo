package models;

import java.time.LocalDateTime;

public class Order {
    private String orderNumber;
    private String tableNumber;
    private String orderType;
    private String orderStatus;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private double totalAmount;
    private String id;
    private String status;

    public Order(String id) {
        this.id = id;
        this.status = "PENDING";
    }

    public String getId() { return id; }
    public double getTotalAmount() { return totalAmount; }

    public void addAmount(double amount) {
        totalAmount += amount;
    }

    public void complete() {
        status = "COMPLETED";
        }
}