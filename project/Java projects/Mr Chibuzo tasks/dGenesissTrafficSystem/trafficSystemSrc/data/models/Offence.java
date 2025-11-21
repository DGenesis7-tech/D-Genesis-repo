package data.models;

public enum Offence {
    DRUNK_DRIVING("Driving under influence", 50000),
    UNDER_AGED("Not up to 18!!", 50000),
    SEAT_BELTS("No Seatbelts", 50000),
    FAKE_ID("Invalid ID", 50000);

    private final String description;
    private final int price;

    Offence(String description, int price) {
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public static Offence fromDescription(String description) {
        for (Offence offence : Offence.values()) {
            if (offence.description.equalsIgnoreCase(description)) {
                return offence;
            }
        }
        return null;
    }
}
