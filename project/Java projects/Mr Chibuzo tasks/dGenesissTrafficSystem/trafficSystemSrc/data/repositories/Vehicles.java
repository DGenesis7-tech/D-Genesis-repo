package data.repositories;

import data.models.Owner;
import data.models.Vehicle;

import java.time.Year;
import java.util.ArrayList;

public class Vehicles implements VehicleRepository{
    private ArrayList<Vehicle> vehicles;
    private int id = 100;
    private int count = 0;

    public Vehicles(Vehicle vehicle, int id, int count) {
        this.vehicles = new ArrayList<>(0);
        this.id = id;
        this.count = count;

    }

    public Vehicles() {
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        for (int index = 0; index < vehicles.size(); index++) {
            if (vehicle.equals(vehicles.get(index))) {
                updateVehicle(vehicle);
                this.count++;
            }
            else {
                vehicles.add(vehicle);

                this.count++;
            }
        }
            return vehicle;
    }

    public void updateVehicle(Vehicle vehicle) {
        String newName = vehicle.getName();
        String newModel = vehicle.getModel();
        Year newYear = vehicle.getYear();
        String newPlateNumber = vehicle.getPlateNumber();
        vehicle.setName(newName);
        vehicle.setModel(newModel);
        vehicle.setYear(newYear);
        vehicle.setPlateNumber(newPlateNumber);
        vehicle.setOwner(new Owner());
        this.vehicles.add(vehicle);
    }

    @Override
    public Vehicle findById(int id) {
        for (int index = 0; index < vehicles.size(); index++) {
            if (id == index) {
                return vehicles.get(index);
            }
        }
        return vehicles.get(id) ;
    }

    @Override
    public ArrayList<Vehicle> findAll() {
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
       return this.count = vehicles.size();
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return this.count;
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
