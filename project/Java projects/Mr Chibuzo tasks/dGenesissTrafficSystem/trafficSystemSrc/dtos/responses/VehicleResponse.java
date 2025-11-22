package dtos.responses;

import data.models.Gender;
import data.models.Owner;

import java.time.Year;

public class VehicleResponse {
    private String name;
    private String model;
    private Year year;
    private String plateNumber;
    private String ownerName;
    private Gender ownerGender;
    private String ownerAddress;
    private String ownerEmail;
    private long ownerPhone;
    private Owner owner;

    public VehicleResponse(String name, String model, Year year, String plateNumber, Owner owner) {
        this.name = name;
        this.model = model;
        this.year = year;
        this.plateNumber = plateNumber;
        this.owner = owner;
    }

    public String getName() { return name; }
    public String getModel() { return model; }
    public Year getYear() { return year; }
    public String getPlateNumber() { return plateNumber; }
    public String getOwnerName() { return ownerName; }
    public Gender getOwnerGender() { return ownerGender; }
    public String getOwnerAddress() { return ownerAddress; }
    public String getOwnerEmail() { return ownerEmail; }
    public long getOwnerPhone() { return ownerPhone; }
    public Owner getOwner() { return owner; }

    public void setName(String name) { this.name = name; }
    public void setModel(String model) { this.model = model; }
    public void setYear(Year year) { this.year = year; }
    public void setPlateNumber(String plateNumber) { this.plateNumber = plateNumber; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }
    public void setOwnerGender(Gender ownerGender) { this.ownerGender = ownerGender; }
    public void setOwnerAddress(String ownerAddress) { this.ownerAddress = ownerAddress; }
    public void setOwnerEmail(String ownerEmail) { this.ownerEmail = ownerEmail; }
    public void setOwnerPhone(long ownerPhone) { this.ownerPhone = ownerPhone; }
    public void setOwner(String ownerName, String ownerAddress, String ownerEmail, long ownerPhone, Gender ownerGender) {
        this.owner  = new Owner(getName(), getOwnerAddress(), getOwnerEmail(), getOwnerPhone(), getOwnerGender());
    }

    @Override
    public String toString() {
        return "Vehicle: " + name + " " + model + " (" + year + "), Plate: " + plateNumber +
                ", Owner: " + ownerName + " (" + ownerGender + ")";
    }


}
