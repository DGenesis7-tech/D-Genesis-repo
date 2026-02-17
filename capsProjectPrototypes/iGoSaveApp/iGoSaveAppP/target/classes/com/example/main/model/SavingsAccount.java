package model;

public class SavingsAccount {
    private double totalSaved;

    public SavingsAccount() {
        this.totalSaved = 0.0;
    }

    public double getTotalSaved() {
        return totalSaved;
    }

    public void addSavedAmount(double amount){
        if(amount > 0){
            this.totalSaved += amount;
        }
    }

}
