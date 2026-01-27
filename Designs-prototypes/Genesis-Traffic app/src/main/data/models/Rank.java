package data.models;

public enum Rank {
    PRIVATE,
    CONSTABLE,
    WARDEN,
    INSPECTOR,
    SUPERINTENDENT;

    public static boolean contains(String ranking) {
        for (Rank rank : Rank.values()) {
            if (rank.name().equalsIgnoreCase(ranking)) return false;
        }
        return true;
    }

}

