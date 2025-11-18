package data.repositories;

import data.models.Gender;
import data.models.Vehicle;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface VehicleRepository {
    Vehicle save(Vehicle vehicle);

    Vehicle findById(int id);
    ArrayList<Vehicle> findAll();
    void deleteById(int id);
    void delete(Vehicle vehicle);
    void deleteAll();
    long count();
    void updateVehicle(Vehicle vehicle, String newName, String newPlateNumber, Year newYear, String newModel, String newOwnerName, String newAddress, String newEmail, long newPhoneNumber, Gender newGender);
}
