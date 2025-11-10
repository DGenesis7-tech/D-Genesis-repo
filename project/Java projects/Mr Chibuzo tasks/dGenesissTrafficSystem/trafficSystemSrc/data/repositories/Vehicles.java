package data.repositories;

import data.models.Vehicle;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Vehicles implements VehicleRepository{
    private Vehicle vehicle;
    private List<Vehicle> vehicles;
    private int id = 100;

    public Vehicles(Vehicle vehicle, int id) {
        this.vehicle = vehicle;
        this.vehicles = new ArrayList<>();
        this.id = id;
    }

    @Override
    public Vehicle save(Vehicle vehicle, Scanner input) {
        for (Vehicle object : vehicles) {
            if (vehicle == object) {
                System.out.println("Enter new name");
                String name = input.nextLine();
                System.out.println("Enter new model");
                String model = input.nextLine();
                System.out.println("Enter new year");
                Year newYear = Year.of(input.nextInt());
                System.out.println("Enter new plate number");
                String plateNumber = input.nextLine();

                updateVehicle(name, model, newYear, plateNumber);
            }
            else  {
                vehicles.add(vehicle);
                count();
            }
        }
        return vehicle;
    }

    private void updateVehicle(String newName, String newModel, Year newYear, String newPlateNumber) {
        vehicle.setName(newName);
        vehicle.setModel(newModel);
        vehicle.setYear(newYear);
        vehicle.setPlateNumber(newPlateNumber);
    }

    @Override
    public Vehicle findById(int id) {
        for (int index = 0; index < vehicles.size(); index++) {
            if (id == index) {
                return vehicles.get(index);
            }
        }
        return vehicle;
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicles;
    }

    @Override
    public void deleteById(int id) {
        for (int index = 0; index < vehicles.size(); index++) {
            if (id == index) {
                vehicles.remove(vehicles.get(index));
                System.out.println("Vehicle has been deleted");
            }
            else {
                System.out.println("invalid id");
        }
        }
    }

    @Override
    public void delete(Vehicle vehicle) {
        for (Vehicle object : vehicles) {
            if (vehicle == object) {
                vehicles.remove(object);
                System.out.println("Vehicle has been deleted");
            }
        }
        System.out.println("Vehicle not found");
    }

    @Override
    public void deleteAll() {
        vehicles.clear();
    }

    @Override
    public long count() {
        return vehicles.size();

    }

    public void setId() {
        for (int index = 0; index < vehicles.size(); index++) {
            this.id += vehicles.size();
        }
    }

    public int getId() {
        return this.id;
    }
}
