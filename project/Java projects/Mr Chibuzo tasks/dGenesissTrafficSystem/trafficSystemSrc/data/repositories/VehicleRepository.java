package data.repositories;

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
}
