package system.lastma;

import data.models.*;
import dtos.requests.IssueTicketRequest;
import dtos.requests.OfficerRequest;
import dtos.requests.VehicleRequest;
import dtos.responses.IssueTicketResponse;
import dtos.responses.OfficerResponse;
import dtos.responses.VehicleResponse;
import data.repositories.Officers;
import data.repositories.Tickets;
import data.repositories.Vehicles;
import services.*;

import javax.swing.*;
import java.time.Year;

public class Main {
    private static final Officers officerRepo = new Officers();
    private static final Vehicles vehicleRepo = new Vehicles();
    private static final Tickets ticketRepo = new Tickets();

    private static final OfficerServices officerServices = new OfficerServicesImpl(officerRepo);
    private static final VehicleServices vehicleServices = new VehicleServicesImpl(vehicleRepo);
    private static final TicketService ticketService = new TicketServicesImpl();

    public static void main(String[] args) {
        while (true) {
            String menu = """
                    === TRAFFIC SYSTEM MENU ===
                    1 -> Register Officer
                    2 -> Register Vehicle
                    3 -> View All Officers
                    4 -> View All Vehicles
                    5 -> Update Officer
                    6 -> Update Vehicle
                    7 -> Issue Ticket
                    8 -> View All Tickets
                    0 -> Exit
                    """;

            String input = JOptionPane.showInputDialog(menu);

            if (input == null) System.exit(0);

            switch (input) {
                case "1" -> registerOfficer();
                case "2" -> registerVehicle();
                case "3" -> viewAllOfficers();
                case "4" -> viewAllVehicles();
                case "5" -> updateOfficer();
                case "6" -> updateVehicle();
                case "7" -> issueTicket();
                case "8" -> viewTickets();
                case "0" -> System.exit(0);
                default -> JOptionPane.showMessageDialog(null, "Invalid Option");
            }
        }
    }

    private static void registerOfficer() {
        String name = JOptionPane.showInputDialog("Officer name:");
        String ranked = JOptionPane.showInputDialog("Rank:").toUpperCase();
        Rank rank = Rank.valueOf(ranked);
        OfficerRequest request = new OfficerRequest(name, rank);
        OfficerResponse response = officerServices.createOfficer(request);
        JOptionPane.showMessageDialog(null, response.toString());
    }

    private static void updateOfficer() {
        String id = JOptionPane.showInputDialog("Enter Officer ID:");
        Officer officer = officerServices.findOfficerById(id);
        if (officer == null) {
            JOptionPane.showMessageDialog(null, "Officer not found.");
            return;
        }

        String name = JOptionPane.showInputDialog("New name:");
        Rank rank = Rank.valueOf(JOptionPane.showInputDialog("New rank:").toUpperCase());

        OfficerRequest request = new OfficerRequest(name, rank);
        officerServices.updateOfficer(id, request);
        JOptionPane.showMessageDialog(null, "Officer updated.");
    }

    private static void viewAllOfficers() {
        StringBuilder builder = new StringBuilder();
        for (OfficerResponse o : officerServices.getAllOfficers()) {
            builder.append(o).append("\n");
        }
        JOptionPane.showMessageDialog(null, builder.toString());
    }

    private static void registerVehicle() {
        String name = JOptionPane.showInputDialog("Vehicle name:");
        String model = JOptionPane.showInputDialog("Vehicle model:");
        String plateNum = JOptionPane.showInputDialog("Plate number:");
        int yearInput = Integer.parseInt(JOptionPane.showInputDialog("Year:"));
        String ownerName = JOptionPane.showInputDialog("Owner name:");
        String ownerAddress = JOptionPane.showInputDialog("Owner address:");
        String ownerEmail = JOptionPane.showInputDialog("Owner email:");
        long ownerPhone = Long.parseLong(JOptionPane.showInputDialog("Owner phone:"));
        Gender ownerGender = Gender.valueOf(JOptionPane.showInputDialog("Owner gender:").toUpperCase());

        VehicleRequest request = new VehicleRequest();
        request.setName(name);
        request.setModel(model);
        request.setPlateNumber(plateNum);
        request.setYear(Year.of(yearInput));
        request.setOwnerName(ownerName);
        request.setOwnerAddress(ownerAddress);
        request.setOwnerEmail(ownerEmail);
        request.setOwnerPhone(ownerPhone);
        request.setOwnerGender(ownerGender);

        VehicleResponse response = vehicleServices.createVehicle(request);
        JOptionPane.showMessageDialog(null, response.toString());
    }

    private static void viewAllVehicles() {
        StringBuilder builder = new StringBuilder();
        for (VehicleResponse v : vehicleServices.getAllVehicles()) {
            builder.append(v).append("\n");
        }
        JOptionPane.showMessageDialog(null, builder.toString());
    }

    private static void updateVehicle() {
        String plate = JOptionPane.showInputDialog("Plate number:");
        Vehicle foundVehicle = vehicleRepo.findByPlateNumber(plate);
        if (foundVehicle == null) {
            JOptionPane.showMessageDialog(null, "Vehicle not found.");
            return;
        }

        String name = JOptionPane.showInputDialog("New name:");
        String model = JOptionPane.showInputDialog("New model:");

        VehicleRequest request = new VehicleRequest();
        request.setName(name);
        request.setModel(model);

        vehicleServices.updateVehicle(foundVehicle, request);
        JOptionPane.showMessageDialog(null, "Vehicle updated.");
    }

    private static void issueTicket() {
        int ticketId = Integer.parseInt(JOptionPane.showInputDialog("Ticket ID:"));
        String plate = JOptionPane.showInputDialog("Vehicle plate:");
        String officerId = JOptionPane.showInputDialog("Officer ID:");
        String offence = JOptionPane.showInputDialog("Offence:");
        int payment = Integer.parseInt(JOptionPane.showInputDialog("Payment:"));

        IssueTicketRequest request = new IssueTicketRequest();
        request.setTicketId(ticketId);
        request.setVehicleId(plate);
        request.setOfficerId(officerId);
        request.setOffenceDescription(offence);
        request.setPayment(payment);

        IssueTicketResponse response = ticketService.issue(request);
        JOptionPane.showMessageDialog(null, response.getMessage());
    }

    private static void viewTickets() {
        StringBuilder builder = new StringBuilder();
        for (Ticket t : ticketRepo.findAll()) {
            builder.append(t).append("\n");
        }
        JOptionPane.showMessageDialog(null, builder.toString());
    }
}
