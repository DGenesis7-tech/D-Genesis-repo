package dtos.responses;

import data.models.Offence;
import data.models.Vehicle;
import data.models.Officer;

import java.time.LocalDateTime;

public class ViewTicketResponse {
    private int ticketId;
    private Vehicle vehicle;
    private Offence offence;
    private Officer issuer;
    private LocalDateTime dateOfBooking;
    private boolean hasPaid;

    public ViewTicketResponse() {}

    public ViewTicketResponse(int ticketId, Vehicle vehicle, Offence offence, Officer issuer, LocalDateTime dateOfBooking, boolean hasPaid) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.offence = offence;
        this.issuer = issuer;
        this.dateOfBooking = dateOfBooking;
        this.hasPaid = hasPaid;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
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

    public boolean isHasPaid() {
        return hasPaid;
    }

    public void setHasPaid(boolean hasPaid) {
        this.hasPaid = hasPaid;
    }
}
