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

    public Vehicle(String name, String model, Year year, String plateNumber, Owner owner) {
        this.name = name;
        this.model = model;
        this.year = year;
        this.plateNumber = plateNumber;
        this.owner = owner;
        this.tickets = new ArrayList<>();
    }

    public Vehicle() {
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

    public void setOwner(String owner) {

        this.owner = owner;
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
}
