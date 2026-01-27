package dtos.requests;

import data.models.Gender;
import java.time.Year;

public class VehicleRequest {
    private String name;
    private String model;
    private Year year;
    private String plateNumber;
    private String ownerName;
    private String ownerAddress;
    private String ownerEmail;
    private long ownerPhone;
    private Gender ownerGender;

    public VehicleRequest() {
    }

    public VehicleRequest(String name, String model, Year year, String plateNumber, String ownerName, String ownerAddress, String ownerEmail, long ownerPhone, Gender ownerGender) {
        this.name = name;
        this.model = model;
        this.year = year;
        this.plateNumber = plateNumber;
        this.ownerName = ownerName;
        this.ownerAddress = ownerAddress;
        this.ownerEmail = ownerEmail;
        this.ownerPhone = ownerPhone;
        this.ownerGender = ownerGender;
    }

    public String getName() { return name; }
    public String getModel() { return model; }
    public Year getYear() { return year; }
    public String getPlateNumber() { return plateNumber; }
    public String getOwnerName() { return ownerName; }
    public String getOwnerAddress() { return ownerAddress; }
    public String getOwnerEmail() { return ownerEmail; }
    public long getOwnerPhone() { return ownerPhone; }
    public Gender getOwnerGender() { return ownerGender; }

    public void setName(String name) { this.name = name; }
    public void setModel(String model) { this.model = model; }
    public void setYear(Year year) { this.year = year; }
    public void setPlateNumber(String plateNumber) { this.plateNumber = plateNumber; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }
    public void setOwnerAddress(String ownerAddress) { this.ownerAddress = ownerAddress; }
    public void setOwnerEmail(String ownerEmail) { this.ownerEmail = ownerEmail; }
    public void setOwnerPhone(long ownerPhone) { this.ownerPhone = ownerPhone; }
    public void setOwnerGender(Gender ownerGender) { this.ownerGender = ownerGender; }
}
