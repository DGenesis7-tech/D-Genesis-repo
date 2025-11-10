package data.models;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.reverse;

public enum Offence {
    DRUNK_DRIVING("Driving under influence", 50000),

    UNDER_AGED("Not up to 18!!", 50000),

    SEAT_BELTS("No Seatbelts", 50000),

    FAKE_ID("Invalid ID", 50000);

    Offence(String description, int price) {
        describe(description);
    }

    void describe(String descriptionAKA) {
        for (Offence offence : Offence.values()) {
            if (offence.toString().equals(descriptionAKA)) {
                System.out.println(offence);
            }
        }
    }

    int price(String descriptionAKA) {
        for (Offence offence : Offence.values()) {
            if (offence.toString().equals(descriptionAKA)) {
                return parseInt(offence.toString());
            }
        }

        return 4000;
    }
}

