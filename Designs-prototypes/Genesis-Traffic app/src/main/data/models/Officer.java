package data.models;

public class Officer {
    private String id;
    private String name;
    private Rank rank;
    private static int count = 1000;

    public Officer(String name, Rank rank) {
        this.name = name;
        this.rank = rank;
        this.id = generateId(rank);
    }

    public Officer() { }

    @Override
    public String toString() {
        return "Officer{id=" + id + ", name='" + name + "', rank=" + rank + "}";
    }

    public String getId() { return id; }

    private String generateId(Rank rank) {
        if (rank == Rank.PRIVATE) return "P" + (++count);
        if (rank == Rank.CONSTABLE) return "C" + (++count);
        if (rank == Rank.WARDEN) return "W" + (++count);
        if (rank == Rank.INSPECTOR) return "I" + (++count);
        if (rank == Rank.SUPERINTENDENT) return "S" + (++count);
        return "X" + (++count);
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Rank getRank() { return rank; }
    public void setRank(Rank rank) {
        this.rank = rank;
        this.id = generateId(rank);
    }
}
