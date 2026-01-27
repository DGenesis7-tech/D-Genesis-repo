package data.models;

import java.time.LocalDateTime;

public class Ticket {
    private int id;
    private Vehicle vehicle;
    private Offence offence;
    private Officer issuer;
    private LocalDateTime dateOfBooking;
    private boolean hasPaid;
    private LocalDateTime dateOfPayment;

    public Ticket() {}

    public Ticket(int id, Vehicle vehicle, Offence offence, Officer issuer, LocalDateTime dateOfBooking, boolean hasPaid, LocalDateTime dateOfPayment) {
        this.id = id;
        this.vehicle = vehicle;
        this.offence = offence;
        this.issuer = issuer;
        this.dateOfBooking = dateOfBooking;
        this.hasPaid = hasPaid;
        this.dateOfPayment = dateOfPayment;
    }

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


    public void setDateOfPayment(LocalDateTime dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public LocalDateTime getDateOfPayment() {
        return dateOfPayment;
    }


    public boolean isHasPaid() {
        return hasPaid;
    }

    public void setHasPaid(int amount, Offence offence) {
        this.hasPaid = hasPaid;
    }

    @Override
    public String toString() {
        return "Ticket ID: " + id +
                ", Vehicle: " + (vehicle != null ? vehicle.getPlateNumber() : "N/A") +
                ", Offence: " + (offence != null ? offence.getDescription() : "N/A") +
                ", Issuer: " + (issuer != null ? issuer.getName() : "N/A") +
                ", Date of Booking: " + (dateOfBooking != null ? dateOfBooking : "N/A") +
                ", Paid: " + hasPaid;
    }
}
