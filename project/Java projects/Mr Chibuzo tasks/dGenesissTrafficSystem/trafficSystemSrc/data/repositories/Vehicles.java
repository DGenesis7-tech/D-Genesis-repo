package data.repositories;

import data.models.Owner;
import data.models.Vehicle;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class Vehicles implements VehicleRepository{
    private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
    private int id = 100;
    private int count = 0;

    public Vehicles(Vehicle vehicle, int id, int count) {
        this.id = id;
        this.count = count;
        this.vehicles = new ArrayList<>(1);
        this.vehicles.add(vehicle);
    }

    public Vehicles() {
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        for (int index = 0; index <= vehicles.size(); index++) {
            if (!vehicle.equals(vehicles.get(index))) {
                vehicles.add(vehicle);
            }
            this.count++;
        }
        return vehicle;
    }

    public void updateVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
        vehicle.setName(String newName);
        vehicle.setModel(newModel);
        vehicle.setYear(newYear);
        vehicle.setPlateNumber(newPlateNumber);
        vehicle.setOwner(String.valueOf(new Owner()));
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
        return this.vehicles;
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

    public void setId(Vehicle vehicle) {
        for (int index = 0; index <= vehicles.size(); index++) {
            if (vehicle == vehicles.get(index)) {
                this.id = this.id + index;
            }
        }

    }

    public int getId() {
        return this.id;
    }
}
