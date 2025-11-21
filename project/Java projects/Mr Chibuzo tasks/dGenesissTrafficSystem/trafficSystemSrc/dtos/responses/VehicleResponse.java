package dtos.responses;

import data.models.Gender;
import java.time.Year;

public class VehicleResponse {
    private String name;
    private String model;
    private Year year;
    private String plateNumber;
    private String ownerName;
    private Gender ownerGender;

    public VehicleResponse(String name, String model, Year year, String plateNumber, String ownerName, Gender ownerGender) {
        this.name = name;
        this.model = model;
        this.year = year;
        this.plateNumber = plateNumber;
        this.ownerName = ownerName;
        this.ownerGender = ownerGender;
    }

    public String getName() { return name; }
    public String getModel() { return model; }
    public Year getYear() { return year; }
    public String getPlateNumber() { return plateNumber; }
    public String getOwnerName() { return ownerName; }
    public Gender getOwnerGender() { return ownerGender; }

    public void setName(String name) { this.name = name; }
    public void setModel(String model) { this.model = model; }
    public void setYear(Year year) { this.year = year; }
    public void setPlateNumber(String plateNumber) { this.plateNumber = plateNumber; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }
    public void setOwnerGender(Gender ownerGender) { this.ownerGender = ownerGender; }

    @Override
    public String toString() {
        return "Vehicle {Name='" + name + "', Model='" + model + "', Year=" + year +
                ", Plate='" + plateNumber + "', Owner='" + ownerName + "', Gender=" + ownerGender + "}";
    }
}
