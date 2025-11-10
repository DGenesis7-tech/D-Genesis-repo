package data.repositories;

import data.models.Vehicle;

import java.util.List;
import java.util.Scanner;

public interface VehicleRepository {
    Vehicle save(Vehicle vehicle, Scanner input);
    Vehicle findById(int id);
    List<Vehicle> findAll();
    void deleteById(int id);
    void delete(Vehicle vehicle);
    void deleteAll();
    long count();
}
