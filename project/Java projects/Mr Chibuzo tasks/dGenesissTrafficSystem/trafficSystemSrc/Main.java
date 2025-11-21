import data.models.Officer;
import data.models.Rank;
import data.models.Vehicle;
import dtos.requests.OfficerRequest;
import dtos.requests.VehicleRequest;
import dtos.responses.OfficerResponse;
import dtos.responses.VehicleResponse;
import services.OfficerServices;
import services.OfficerServicesImpl;
import services.VehicleServices;
import services.VehicleServicesImpl;
import data.repositories.Officers;
import data.repositories.Vehicles;

import java.time.Year;
import java.util.Scanner;

public class Main {
    private static final Officers officerRepo = new Officers();
    private static final Vehicles vehicleRepo = new Vehicles();
    private static final OfficerServices officerServices = new OfficerServicesImpl(officerRepo);
    private static final VehicleServices vehicleServices = new VehicleServicesImpl(vehicleRepo);
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
                    0 -> Exit
                    """;

            System.out.println(menu);
            System.out.print("Choose an option: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1" -> registerOfficer();
                case "2" -> registerVehicle();
                case "3" -> viewOfficers();
                case "4" -> viewVehicles();
                case "5" -> updateOfficer();
                case "6" -> updateVehicle();
                case "0" -> {
                    System.out.println("Exiting... Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid Option. Try again.");
            }
        }
    }

    private static void registerOfficer() {
        System.out.print("Officer name: ");
        String name = scanner.nextLine();
        System.out.print("Officer rank (PRIVATE, CONSTABLE, WARDEN, INSPECTOR, SUPERINTENDENT): ");
        String rankInput = scanner.nextLine().toUpperCase();
        Rank rank;
        try {
            rank = Rank.valueOf(rankInput);
        } catch (Exception e) {
            System.out.println("Invalid rank!");
            return;
        }

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
        String plate = scanner.nextLine();
        System.out.print("Year: ");
        int yearInput = Integer.parseInt(scanner.nextLine());
        System.out.print("Owner name: ");
        String ownerName = scanner.nextLine();

        VehicleRequest request = new VehicleRequest();
        request.setName(name);
        request.setModel(model);
        request.setPlateNumber(plate);
        request.setYear(Year.of(yearInput));
        request.setOwnerName(ownerName);

        VehicleResponse response = vehicleServices.createVehicle(request);
        System.out.println("Added Vehicle: " + response);
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
        String rankInput = scanner.nextLine().toUpperCase();
        Rank rank;
        try {
            rank = Rank.valueOf(rankInput);
        } catch (Exception e) {
            System.out.println("Invalid rank!");
            return;
        }

        OfficerRequest request = new OfficerRequest(name, rank);
        officerServices.updateOfficer(officer, request);
        System.out.println("Officer updated successfully.");
    }

    private static void updateVehicle() {
        System.out.print("Vehicle plate number: ");
        String plate = scanner.nextLine();
        Vehicle foundVehicle = null;
        for (Vehicle vehicle : vehicleServices.getAllVehicles()) {
            if (vehicle.getPlateNumber().equals(plate)) {
                foundVehicle = vehicle;
                break;
            }
        }
        if (foundVehicle == null) {
            System.out.println("Vehicle not found.");
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
}
