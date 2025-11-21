package dtos.responses;

import data.models.Ticket;
import java.util.List;

public class ViewTicketsByVehicleResponse {
    private String vehicleId;
    private String vehiclePlateNumber;
    private List<Ticket> tickets;

    public ViewTicketsByVehicleResponse() {}

    public ViewTicketsByVehicleResponse(String vehicleId, String vehiclePlateNumber, List<Ticket> tickets) {
        this.vehicleId = vehicleId;
        this.vehiclePlateNumber = vehiclePlateNumber;
        this.tickets = tickets;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehiclePlateNumber() {
        return vehiclePlateNumber;
    }

    public void setVehiclePlateNumber(String vehiclePlateNumber) {
        this.vehiclePlateNumber = vehiclePlateNumber;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
