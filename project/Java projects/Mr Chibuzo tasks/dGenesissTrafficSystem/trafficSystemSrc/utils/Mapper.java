package utils;

import data.models.*;
import dtos.requests.OfficerRequest;
import dtos.requests.VehicleRequest;
import dtos.requests.IssueTicketRequest;
import dtos.responses.OfficerResponse;
import dtos.responses.VehicleResponse;
import dtos.responses.ViewTicketResponse;
import dtos.responses.ViewTicketsByVehicleResponse;
import java.util.ArrayList;
import java.util.List;

public class Mapper {

    public static Officer mapRequestToOfficer(OfficerRequest request) {
        return new Officer(request.getName(), request.getRank());
    }

    public static OfficerResponse mapOfficerToResponse(Officer officer) {
        return new OfficerResponse(officer.getId(), officer.getName(), officer.getRank());
    }

    public static List<OfficerResponse> mapOfficerListToResponseList(List<Officer> officers) {
        List<OfficerResponse> responses = new ArrayList<>();
        for (Officer officer : officers) {
            responses.add(mapOfficerToResponse(officer));
        }
        return responses;
    }

    public static Vehicle mapRequestToVehicle(VehicleRequest request) {
        Owner owner = new Owner(
                request.getOwnerName(),
                request.getOwnerAddress(),
                request.getOwnerPhone(),
                request.getOwnerGender(),
                request.getOwnerEmail(),
                null
        );
        return new Vehicle(
                request.getName(),
                request.getModel(),
                request.getYear(),
                request.getPlateNumber(),
                null,
                owner
        );
    }

    public static VehicleResponse mapVehicleToResponse(Vehicle vehicle) {
        return new VehicleResponse(
                vehicle.getName(),
                vehicle.getModel(),
                vehicle.getYear(),
                vehicle.getPlateNumber(),
                vehicle.getOwner().getName(),
                vehicle.getOwner().getGender()
        );
    }

    public static List<VehicleResponse> mapVehicleListToResponseList(List<Vehicle> vehicles) {
        List<VehicleResponse> responses = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            responses.add(mapVehicleToResponse(vehicle));
        }
        return responses;
    }

    public static void updateVehicleFromRequest(Vehicle vehicle, VehicleRequest request) {
        vehicle.setName(request.getName());
        vehicle.setModel(request.getModel());
        vehicle.setYear(request.getYear());
        vehicle.setPlateNumber(request.getPlateNumber());
        vehicle.setOwner(
                request.getOwnerName(),
                request.getOwnerAddress(),
                request.getOwnerEmail(),
                request.getOwnerPhone(),
                request.getOwnerGender()
        );
    }

    public static Ticket mapIssueTicketRequestToTicket(IssueTicketRequest request, Vehicle vehicle, Officer officer, Offence offence) {
        Ticket ticket = new Ticket();
        ticket.setId(request.getTicketId());
        ticket.setVehicle(vehicle);
        ticket.setIssuer(officer);
        ticket.setOffence(offence);
        ticket.setHasPaid(request.getPayment(), offence);
        return ticket;
    }

    public static ViewTicketResponse mapTicketToResponse(Ticket ticket) {
        return new ViewTicketResponse(
                ticket.getId(),
                ticket.getVehicle(),
                ticket.getOffence(),
                ticket.getIssuer(),
                ticket.getDateOfBooking(),
                ticket.isHasPaid()
        );
    }

    public static List<ViewTicketResponse> mapTicketListToResponseList(List<Ticket> tickets) {
        List<ViewTicketResponse> responses = new ArrayList<>();
        for (Ticket ticket : tickets) {
            responses.add(mapTicketToResponse(ticket));
        }
        return responses;
    }

    public static ViewTicketsByVehicleResponse mapVehicleAndTicketsToResponse(Vehicle vehicle, List<Ticket> tickets) {
        return new ViewTicketsByVehicleResponse(
                vehicle.getId(),
                vehicle.getPlateNumber(),
                tickets
        );
    }
}
