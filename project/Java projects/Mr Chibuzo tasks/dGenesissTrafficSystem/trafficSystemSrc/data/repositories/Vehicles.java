package data.repositories;

import data.models.Vehicle;
import data.models.Gender;
import java.time.Year;

public class Vehicles extends GenericTypesRepository<Vehicle> implements VehicleRepository {

    @Override
    public Vehicle findById(int id) {
        return findByIndex(id - 100);
    }

    @Override
    public void deleteById(int id) {
        Vehicle vehicle = findByIndex(id - 100);
        if (vehicle != null) {
            delete(vehicle);
        }
    }

    @Override
    public void updateVehicle(Vehicle vehicle, String newName, String newPlateNumber, Year newYear, String newModel, String newOwnerName, String newAddress, String newEmail, long newPhoneNumber, Gender newGender) {
        if (findAll().contains(vehicle)) {
            vehicle.setName(newName);
            vehicle.setModel(newModel);
            vehicle.setPlateNumber(newPlateNumber);
            vehicle.setYear(newYear);
            vehicle.setOwner(newOwnerName, newAddress, newEmail, newPhoneNumber, newGender);
        }
    }
}
