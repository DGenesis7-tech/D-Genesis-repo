package services;

import data.models.Vehicle;
import dtos.requests.VehicleRequest;
import dtos.responses.VehicleResponse;

import java.util.List;

public interface VehicleServices {
    VehicleResponse createVehicle(VehicleRequest request);
    void updateVehicle(Vehicle vehicle, VehicleRequest request);
    List<VehicleResponse> getAllVehicles();
}
