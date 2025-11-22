package dtos.responses;

import data.models.Rank;

public class OfficerResponse {
    private int id;
    private String name;
    private Rank rank;

    public OfficerResponse() {}

    public OfficerResponse(int id, String name, Rank rank) {
        this.id = id;
        this.name = name;
        this.rank = rank;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public Rank getRank() { return rank; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setRank(Rank rank) { this.rank = rank; }

    @Override
    public String toString() {
        return "Officer ID: " + id + ", Name: " + name + ", Rank: " + rank;
    }
}
