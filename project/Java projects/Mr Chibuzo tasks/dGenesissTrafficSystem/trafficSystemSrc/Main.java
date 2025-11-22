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

import java.time.Year;
import java.util.Scanner;

public class Main {
    private static final Officers officerRepo = new Officers();
    private static final Vehicles vehicleRepo = new Vehicles();
    private static final Tickets ticketRepo = new Tickets();

    private static final OfficerServices officerServices = new OfficerServicesImpl(officerRepo);
    private static final VehicleServices vehicleServices = new VehicleServicesImpl(vehicleRepo);
    private static final TicketService ticketService = new TicketServicesImpl();

    private static final Scanner scanner = new Scanner(System.in);

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

            System.out.println(menu);
            System.out.print("Choose an option: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1" : registerOfficer();
                case "2" : registerVehicle();
                case "3" : viewOfficers();
                case "4" : viewVehicles();
                case "5" : updateOfficer();
                case "6" : updateVehicle();
                case "7" : issueTicket();
                case "8" : viewTickets();
                case "0" : {
                    System.out.println("Exiting... Goodbye!");
                    System.exit(0);
                }
                default : System.out.println("Invalid Option. Try again.");
            }
        }
    }

    private static void registerOfficer() {
        System.out.print("Officer name: ");
        String name = scanner.nextLine();
        System.out.print("Officer rank (PRIVATE, CONSTABLE, WARDEN, INSPECTOR, SUPERINTENDENT): ");
        Rank rank = Rank.valueOf(scanner.nextLine().toUpperCase());

        OfficerRequest request = new OfficerRequest(name, rank);
        OfficerResponse response = officerServices.createOfficer(request);
        System.out.println("Added Officer: " + response);
    }

    private static void registerVehicle() {
        System.out.print("Vehicle name: ");
        String name = scanner.nextLine();
        System.out.print("Vehicle model: ");
        String model = scanner.nextLine();
        System.out.print("Plate number: ");
        String plateNum = scanner.nextLine();
        System.out.print("Year: ");
        int yearInput = Integer.parseInt(scanner.nextLine());

        System.out.print("Register Owner: ");
        String ownerName = scanner.nextLine();
        System.out.print("Register Owner's Address: ");
        String ownerAddress = scanner.nextLine();
        System.out.print("Register Owner's Email: ");
        String ownerEmail = scanner.nextLine();
        System.out.print("Register Owner's PhoneNum: ");
        long ownerPhone =  Long.parseLong(scanner.nextLine());
        System.out.print("Register Owner's Gender: ");
        Gender ownerGender = Gender.valueOf(scanner.nextLine().toUpperCase());

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
        System.out.println("Vehicle Registered : " + response);
    }

    private static void viewOfficers() {
        for (OfficerResponse officer : officerServices.getAllOfficers()) {
            System.out.println(officer);
        }
    }

    private static void viewVehicles() {
        for (VehicleResponse vehicle : vehicleServices.getAllVehicles()) {
            System.out.println(vehicle);
        }
    }

    private static void updateOfficer() {
        System.out.print("Officer ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        Officer officer = officerServices.findOfficerById(id);
        if (officer == null) {
            System.out.println("Officer not found.");
            return;
        }

        System.out.print("New name: ");
        String name = scanner.nextLine();
        System.out.print("New rank: ");
        Rank rank = Rank.valueOf(scanner.nextLine().toUpperCase());

        OfficerRequest request = new OfficerRequest(name, rank);
        officerServices.updateOfficer(officer, request);
        System.out.println("Officer updated successfully.");
    }

    private static void updateVehicle() {
        System.out.print("Vehicle plate number: ");
        String plate = scanner.nextLine();

        VehicleResponse foundVehicleResponse = null;
        for (VehicleResponse v : vehicleServices.getAllVehicles()) {
            if (v.getPlateNumber().equals(plate)) {
                foundVehicleResponse = v;
                break;
            }
        }

        if (foundVehicleResponse == null) {
            System.out.println("Vehicle not found.");
            return;
        }

        Vehicle foundVehicle = vehicleRepo.findByPlateNumber(plate);
        if (foundVehicle == null) {
            System.out.println("Vehicle not found in repository.");
            return;
        }

        System.out.print("New name: ");
        String name = scanner.nextLine();
        System.out.print("New model: ");
        String model = scanner.nextLine();

        VehicleRequest request = new VehicleRequest();
        request.setName(name);
        request.setModel(model);

        vehicleServices.updateVehicle(foundVehicle, request);
        System.out.println("Vehicle updated successfully.");
    }



    private static void issueTicket() {
        System.out.print("Ticket ID: ");
        int ticketId = Integer.parseInt(scanner.nextLine());
        System.out.print("Vehicle plate number: ");
        String plate = scanner.nextLine();
        System.out.print("Officer ID: ");
        int officerId = Integer.parseInt(scanner.nextLine());
        System.out.print("Offence description: ");
        String offenceDescription = scanner.nextLine();
        System.out.print("Payment amount: ");
        int payment = Integer.parseInt(scanner.nextLine());

        IssueTicketRequest request = new IssueTicketRequest();
        request.setTicketId(ticketId);
        request.setVehicleId(plate);
        request.setOfficerId(officerId);
        request.setOffenceDescription(offenceDescription);
        request.setPayment(payment);

        IssueTicketResponse response = ticketService.issue(request);
        System.out.println(response.getMessage());
    }

    private static void viewTickets() {
        for (Ticket ticket : ticketRepo.findAll()) {
            System.out.println(ticket);
        }
    }
}
