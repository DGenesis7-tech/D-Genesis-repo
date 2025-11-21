package data.models;

public enum Gender {
    MALE,
    FEMALE,
    CURSED;

    @Override
    public String toString() {
        return this.name();
    }

    public String toUpperCase() {
        return this.name().toUpperCase();
    }
}
