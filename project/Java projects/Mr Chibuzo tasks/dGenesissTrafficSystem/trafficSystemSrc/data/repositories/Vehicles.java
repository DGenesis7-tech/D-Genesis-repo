package data.repositories;

import data.models.Vehicle;
import data.models.Gender;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class Vehicles extends GenericTypesRepository<Vehicle> implements VehicleRepository {
    private Vehicle vehicle = new Vehicle();
    private final List<Vehicle> vehicles = new ArrayList<>();

    @Override
    public Vehicle findById(int id) {
        return findByIndex(id - 100);
    }

    @Override
    public void deleteById(int id) {
        this.vehicle = findByIndex(id - 100);
        if (vehicle != null) {
            delete(vehicle);
        }
    }

    @Override
    public void updateVehicle(Vehicle vehicle, String newName, String newPlateNumber, Year newYear, String newModel, String newOwnerName, String newAddress, String newEmail, long newPhoneNumber, Gender newGender) {
        if (findAll().contains(vehicle)) {
            this.vehicle.setName(newName);
            this.vehicle.setModel(newModel);
            this.vehicle.setPlateNumber(newPlateNumber);
            this.vehicle.setYear(newYear);
            this.vehicle.setOwner(newOwnerName, newAddress, newEmail, newPhoneNumber, newGender);
        }
    }

    public Vehicle findByPlateNumber(String plateNumber) {
        for (Vehicle found : findAll()) {
            if (found.getPlateNumber().equals(plateNumber)) {
                return found;
            }
        }
        return null;
    }

}
