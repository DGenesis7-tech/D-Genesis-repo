package services;

import data.models.Vehicle;
import dtos.requests.VehicleRequest;
import dtos.responses.VehicleResponse;

import java.util.List;

public interface VehicleServices {
    VehicleResponse createVehicle(VehicleRequest request);
    void updateVehicle(VehicleResponse vehicle, VehicleRequest request);
    List<VehicleResponse> getAllVehicles();
    List<Vehicle> getAllVehiclesObject();

    List<Vehicle> getAllVehiclesDomain();

    void updateVehicle(Vehicle foundVehicle, VehicleRequest request);
}
