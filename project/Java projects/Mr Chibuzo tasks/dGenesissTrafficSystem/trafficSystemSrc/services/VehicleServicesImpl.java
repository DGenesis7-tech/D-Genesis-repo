package services;

import controllers.OwnerController;
import dtos.requests.VehicleRequest;
import dtos.responses.VehicleResponse;
import data.models.Vehicle;
import data.repositories.Vehicles;
import utils.Mapper;

import java.util.List;

public class VehicleServicesImpl implements VehicleServices {

    private Vehicles vehicleRepo;

    public VehicleServicesImpl(Vehicles vehicleRepo, OwnerController ownerController) {
        this.vehicleRepo = vehicleRepo;
    }

    public VehicleServicesImpl(Vehicles vehicleRepo) {

    }

    @Override
    public VehicleResponse createVehicle(VehicleRequest request) {
        Vehicle vehicle = Mapper.mapRequestToVehicle(request);
        vehicleRepo.save(vehicle);
        return Mapper.mapVehicleToResponse(vehicle);
    }

    @Override
    public void updateVehicle(VehicleResponse vehicle, VehicleRequest request) {
        Mapper.updateVehicleFromRequest(vehicle, request);
    }

    @Override
    public List<VehicleResponse> getAllVehicles() {
        return Mapper.mapVehicleListToResponseList(vehicleRepo.findAll());
    }

    @Override
    public List<Vehicle> getAllVehiclesObject() {
        return vehicleRepo.findAll();
    }

    @Override
    public List<Vehicle> getAllVehiclesDomain() {
        return List.of();
    }

    @Override
    public void updateVehicle(Vehicle foundVehicle, VehicleRequest request) {

    }

}
