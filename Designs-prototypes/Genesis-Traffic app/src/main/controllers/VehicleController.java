package controllers;

import dtos.requests.VehicleRequest;
import dtos.responses.VehicleResponse;
import data.models.Vehicle;
import services.VehicleServices;

import java.util.List;

public class VehicleController {

    private VehicleServices vehicleServices;

    public VehicleController(VehicleServices vehicleServices) {
        this.vehicleServices = vehicleServices;
    }

    public VehicleResponse createVehicle(VehicleRequest request) {
        return vehicleServices.createVehicle(request);
    }

    public List<VehicleResponse> getAllVehicles() {
        return vehicleServices.getAllVehicles();
    }

    public void updateVehicle(String vehicleId, VehicleRequest request) {
        VehicleResponse foundVehicle = null;
        for (VehicleResponse v : vehicleServices.getAllVehicles()) {
            if (v.getPlateNumber().equals(vehicleId)) {
                foundVehicle = v;
                break;
            }
        }

        if (foundVehicle != null) {
            vehicleServices.updateVehicle(foundVehicle, request);
        } else {
            System.out.println("Vehicle with ID " + vehicleId + " not found.");
        }
    }
}
