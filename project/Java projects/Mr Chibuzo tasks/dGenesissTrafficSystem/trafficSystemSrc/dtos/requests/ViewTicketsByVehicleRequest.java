package dtos.requests;

import java.time.LocalDateTime;

public class ViewTicketsByVehicleRequest {
    private int vehicleId;
    private String vehiclePlateNumber;
    private LocalDateTime fromDate;
    private LocalDateTime toDate;

    public ViewTicketsByVehicleRequest() {}

    public ViewTicketsByVehicleRequest(int vehicleId, String vehiclePlateNumber, LocalDateTime fromDate, LocalDateTime toDate) {
        this.vehicleId = vehicleId;
        this.vehiclePlateNumber = vehiclePlateNumber;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehiclePlateNumber() {
        return vehiclePlateNumber;
    }

    public void setVehiclePlateNumber(String vehiclePlateNumber) {
        this.vehiclePlateNumber = vehiclePlateNumber;
    }

    public LocalDateTime getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDateTime fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDateTime getToDate() {
        return toDate;
    }

    public void setToDate(LocalDateTime toDate) {
        this.toDate = toDate;
    }
}
