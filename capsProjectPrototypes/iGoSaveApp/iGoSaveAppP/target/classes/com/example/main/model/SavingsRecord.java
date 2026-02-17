package model;

import java.time.LocalDateTime;

public class SavingsRecord {
    private String planType;
    private double amount;
    private int duration;
    private double totalSaved;
    private LocalDateTime createdAt;

    public SavingsRecord(String planType, double amount, int duration, double totalSaved, LocalDateTime createdAt) {
        this.planType = planType;
        this.amount = amount;
        this.duration = duration;
        this.totalSaved = totalSaved;
        this.createdAt = createdAt;
    }

    public SavingsRecord() {

    }

    public String getPlanType() {
        return planType;
    }

    public double getAmount() {
        return amount;
    }

    public int getDuration() {
        return duration;
    }

    public double getTotalSaved() {
        return totalSaved;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
