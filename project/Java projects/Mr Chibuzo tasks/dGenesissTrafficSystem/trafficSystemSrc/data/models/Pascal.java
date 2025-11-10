package data.models;

import data.repositories.Vehicles;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pascal {
    Vehicle vehicle;
    Ticket ticket;
    Owner owner;
    Offence offence;
    Officer officer;
    Vehicles vehicles;

    public Pascal() {}

    public void registerOwner(Scanner input) {
        this.owner = new Owner();

        System.out.println("Please enter your name: ");
        String name = input.nextLine();
        this.owner.setName(name);

        System.out.println("Please enter your email address: ");
        String email = input.nextLine();
        this.owner.setEmail(email);

        System.out.println("Please enter your current Address: ");
        String address = input.nextLine();
        this.owner.setAddress(address);

        System.out.println("Please select your gender (male, female, cursed): ");
        String gender = input.next();
        this.owner.setGender(gender);

        System.out.println("Please generate your id: ");
        String id = input.nextLine();
        this.owner.setId(id);

        System.out.println("Please enter your phone number: ");
        long phone = input.nextLong();
        this.owner.setPhone(phone);
    }

    public void registerVehicle(Scanner input) {
        this.vehicle = new Vehicle();
        vehicles.save(vehicle, input);
    }

    public void updateVehicle(Scanner input) {
        this.vehicle = new Vehicle();
        vehicles.save(vehicle, input);
    }

    public void viewTickets(int id) {
        Vehicle vehicle = vehicles.findById(id);
        for (Ticket ticket : vehicle.tickets) {
            System.out.println(ticket.toString());
        }
    }

    public void settleTickets(Scanner input) {
        this.ticket = new Ticket();
        System.out.println("Please enter your vehicle id: ");
        int id = input.nextInt();

        Vehicle vehicle = vehicles.findById(id);
        List<Ticket> tickets = vehicle.tickets;
        for (Ticket ticket : tickets) {
            System.out.println("Please state the offence you would like to settle: : ");
            String state = input.next();
            boolean paid = ticket.isHasPaid();
        }
    }

}
