package data.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Ticket {
    int id;
    Vehicle vehicle;
    Offence offence;
    boolean hasPaid;
    Officer issuer;
    LocalDateTime dateOfBooking;
    LocalDateTime dateOfPayment;

    public Ticket(){}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Offence getOffence() {
        return offence;
    }

    public void setOffence(Offence offence) {
        this.offence = offence;
    }

    public boolean isHasPaid() {
        return hasPaid;
    }

    public void setHasPaid(String describe, int payment) {
        int thePrice = offence.price(describe);
        if (payment < thePrice ) {
            System.out.println("The payment is less than the price of the offence");
        }
        else {
            hasPaid = true;
        }
    }

    public Officer getIssuer() {
        return issuer;
    }

    public void setIssuer(Officer issuer) {
        this.issuer = issuer;
    }

    public LocalDateTime getDateOfBooking() {
        return dateOfBooking;
    }

    public void setDateOfBooking(LocalDateTime dateOfBooking) {
        this.dateOfBooking = dateOfBooking;
    }

    public LocalDateTime getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(LocalDateTime dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }
}
