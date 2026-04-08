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

    public Order(String orderNumber, String tableNumber, String orderType) {
        this.orderNumber = orderNumber;
        this.tableNumber = tableNumber;
        this.orderType = orderType;
        this.orderStatus = "PENDING";
        this.startTime = LocalDateTime.now();
    }

    public void completeOrder() {
        this.orderStatus = "COMPLETED";
        this.endTime = LocalDateTime.now();
    }

    public void addAmount(double amount) {
        totalAmount += amount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getOrderNumber() {
        return orderNumber;
    }
}