package org.example;

import org.example.controllers.UserControllerJson;
import org.example.data.repositories.UserRepository;
import org.example.data.repositories.UserRepositoryImpl;
import org.example.services.UserServiceJson;
import org.example.utils.MapUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static UserControllerJson controller;

    private static String loggedInUserId;
    private static String loggedInUserName;

    public static void main(String[] args) {

        UserRepository userRepository = new UserRepositoryImpl();
        UserServiceJson userService = new UserServiceJson(userRepository);
        controller = new UserControllerJson(userService);

        System.out.println("YOUR 1CONTACT APPLICATION");
        System.out.println("---------------------------");

        authenticationMenu();
        contactsMenu();
    }

    private static void authenticationMenu() {
        while (loggedInUserId == null) {
            System.out.println("\n1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose: ");

            String choice = scanner.nextLine();

            if (choice.equals("1")) registerUser();
            else if (choice.equals("2")) loginUser();
            else if (choice.equals("3")) exit();
            else System.out.println("Invalid option");
        }
    }

    private static void registerUser() {
        Map<String, Object> map = new HashMap<>();

        System.out.print("Full name: ");
        map.put("fullName", scanner.nextLine());

        System.out.print("Username: ");
        map.put("username", scanner.nextLine());

        System.out.print("Email: ");
        map.put("email", scanner.nextLine());

        System.out.print("6 digit pin: ");
        map.put("pin", Integer.parseInt(scanner.nextLine()));

        String response = controller.register(MapUtils.mapToJson(map));
        Map<String, Object> result = MapUtils.jsonToMap(response);

        if (MapUtils.hasKey(result, "error")) {
            System.out.println(result.get("error"));
            return;
        }

        loggedInUserId = String.valueOf(MapUtils.getInt(result, "id"));
        loggedInUserName = MapUtils.getString(result, "fullName");

        System.out.println("Welcome " + loggedInUserName);
    }

    private static void loginUser() {
        Map<String, Object> map = new HashMap<>();

        System.out.print("Username: ");
        map.put("username", scanner.nextLine());

        System.out.print("Pin: ");
        map.put("pin", Integer.parseInt(scanner.nextLine()));

        String response = controller.login(MapUtils.mapToJson(map));
        Map<String, Object> result = MapUtils.jsonToMap(response);

        if (MapUtils.hasKey(result, "error")) {
            System.out.println(result.get("error"));
            return;
        }

        loggedInUserId = String.valueOf(MapUtils.getInt(result, "id"));
        loggedInUserName = MapUtils.getString(result, "fullName");

        System.out.println("Welcome back " + loggedInUserName);
    }

    // ---------------- CONTACT MENU ----------------

    private static void contactsMenu() {
        while (true) {
            System.out.println("\n" + loggedInUserName + "'s Contacts");
            System.out.println("1. View contacts");
            System.out.println("2. Create contact");
            System.out.println("3. Update contact");
            System.out.println("4. Delete contact");
            System.out.println("5. View trash");
            System.out.println("6. Restore from trash");
            System.out.println("7. Sort contacts");
            System.out.println("8. Logout");

            System.out.print("Choose: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) viewContacts();
            else if (choice.equals("2")) createContact();
            else if (choice.equals("3")) updateContact();
            else if (choice.equals("4")) deleteContact();
            else if (choice.equals("5")) viewTrash();
            else if (choice.equals("6")) restoreContact();
            else if (choice.equals("7")) sortMenu();
            else if (choice.equals("8")) logout();
            else System.out.println("Invalid option");
        }
    }

    // ---------------- CONTACT ACTIONS ----------------

    private static void viewContacts() {
        String response = controller.viewContacts(loggedInUserId);
        System.out.println(response);
    }

    private static void createContact() {
        Map<String, Object> map = new HashMap<>();

        System.out.print("Name: ");
        map.put("name", scanner.nextLine());

        System.out.print("Phone number: ");
        map.put("phoneNumber", scanner.nextLine());

        System.out.print("Email: ");
        map.put("email", scanner.nextLine());

        System.out.println(
                controller.createContact(
                        loggedInUserId,
                        MapUtils.mapToJson(map)
                )
        );
    }

    private static void updateContact() {
        Map<String, Object> map = new HashMap<>();

        System.out.print("Contact ID: ");
        map.put("contactId", Integer.parseInt(scanner.nextLine()));

        System.out.print("New name: ");
        map.put("name", scanner.nextLine());

        System.out.print("New phone: ");
        map.put("phoneNumber", scanner.nextLine());

        System.out.print("New email: ");
        map.put("email", scanner.nextLine());

        System.out.println(
                controller.updateContact(
                        loggedInUserId,
                        MapUtils.mapToJson(map)
                )
        );
    }

    private static void deleteContact() {
        System.out.print("Contact ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.println(controller.deleteContact(loggedInUserId, id));
    }

    private static void viewTrash() {
        System.out.println(controller.viewTrash(loggedInUserId));
    }

    private static void restoreContact() {
        System.out.print("Contact ID to restore: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.println(controller.restoreContact(loggedInUserId, id));
    }

    private static void sortMenu() {
        System.out.println("1. Alphabetical");
        System.out.println("2. Last added");
        System.out.print("Choose: ");

        String choice = scanner.nextLine();

        if (choice.equals("1"))
            System.out.println(controller.sortContactsAlphabetically(loggedInUserId));
        else if (choice.equals("2"))
            System.out.println(controller.sortContactsByLastAdded(loggedInUserId));
        else
            System.out.println("Invalid option");
    }

    private static void logout() {
        loggedInUserId = null;
        loggedInUserName = null;
        authenticationMenu();
    }

    private static void exit() {
        System.out.println("Goodbye");
        System.exit(0);
    }
}
