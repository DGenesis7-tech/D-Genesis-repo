package data.models;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class Vehicle {
    String name;
    String model;
    Year year;
    String plateNumber;
    Owner owner;
    List<Ticket> tickets;
    String vehicleId;

    public Vehicle(String name, String model, Year year, String plateNumber, String vehicleId, Owner owner) {
        this.name = name;
        this.model = model;
        this.year = year;
        this.plateNumber = plateNumber;
        this.owner = owner;
        this.tickets = new ArrayList<>();
        this.vehicleId = vehicleId;
    }

    public Vehicle() {
        this.tickets = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Vehicle{name='" + name + "', model='" + model + "', plate='" + plateNumber + "', year=" + year + ", owner=" + owner.getName() + "}";
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(String name, String address, String email, long phoneNumber, Gender gender) {
        if (owner == null) owner = new Owner();
        owner.setName(name);
        owner.setAddress(address);
        owner.setEmail(email);
        owner.setPhone(phoneNumber);
        owner.setGender(gender.toString());
    }


    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public void setId(String vehicleId) {
        this.vehicleId = vehicleId;
    }
    public String getId() {
        return vehicleId;
    }
}
