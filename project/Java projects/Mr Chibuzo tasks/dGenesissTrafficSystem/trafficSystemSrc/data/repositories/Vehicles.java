package data.repositories;

import data.models.Gender;
import data.models.Vehicle;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class Vehicles implements VehicleRepository {

    private List<Vehicle> vehicles = new ArrayList<>();
    private final int repoId = 100;

    @Override
    public Vehicle save(Vehicle vehicle) {
        for (Vehicle veh : vehicles) {
            if (veh.getPlateNumber().equalsIgnoreCase(vehicle.getPlateNumber())) {
                System.out.println("Vehicle with plate number " + veh.getPlateNumber() + " already exists");
                return veh;
            }
        }
        vehicles.add(vehicle);
        return vehicle;
    }

    @Override
    public Vehicle findById(int id) {
        int index = id - this.repoId;

        if (index < 0 || index >= vehicles.size()) {
            System.out.println("Vehicle with id " + id + " does not exist");
            return null;
        }
        return vehicles.get(index);
    }

    @Override
    public ArrayList<Vehicle> findAll() {
        return new ArrayList<>(vehicles);
    }

    @Override
    public void deleteById(int id) {
        int index = id - this.repoId;

        if (index < 0 || index >= vehicles.size()) {
            System.out.println("Vehicle ID " + id + " not found.");
            return;
        }

        vehicles.remove(index);
        System.out.println("Vehicle with id " + id + " has been deleted.");
    }

    @Override
    public void delete(Vehicle vehicle) {
        if (vehicles.remove(vehicle)) {
            System.out.println("Vehicle deleted successfully.");
        } else {
            System.out.println("Vehicle not found.");
        }
    }

    @Override
    public void deleteAll() {
        vehicles.clear();
    }

    @Override
    public long count() {
        return vehicles.size();
    }

    public void updateVehicle(Vehicle vehicle, String newName, String newPlateNumber, Year newYear, String newModel, String newOwnerName, String newAddress, String newEmail, long newPhoneNumber, Gender newGender) {

        if (!vehicles.contains(vehicle)) {
            System.out.println("Vehicle " + vehicle.getPlateNumber() + " not found.");
            return;
        }

        vehicle.setName(newName);
        vehicle.setPlateNumber(newPlateNumber);
        vehicle.setYear(newYear);
        vehicle.setModel(newModel);
        vehicle.setOwner(newOwnerName, newAddress, newEmail, newPhoneNumber, newGender);
    }
}
