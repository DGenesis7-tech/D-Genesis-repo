package models;

public class Admin {
    private String username;
    private String pin;

    public Admin(String username, String pin) {
        this.username = username;
        this.pin = pin;
    }

    public boolean verifyPin(String inputPin) {
        return pin.equals(inputPin);
    }
}
