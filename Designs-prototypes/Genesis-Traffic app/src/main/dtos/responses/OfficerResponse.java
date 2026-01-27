package dtos.responses;

import data.models.Officer;
import data.models.Rank;

public class OfficerResponse {
    private String id;
    private String name;
    private Rank rank;

    public OfficerResponse() { }

    public OfficerResponse(Officer officer) {
        this.id = officer.getId();
        this.name = officer.getName();
        this.rank = officer.getRank();
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public Rank getRank() { return rank; }
    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setRank(Rank rank) { this.rank = rank; }

    @Override
    public String toString() {
        return "Officer ID: " + id + ", Name: " + name + ", Rank: " + rank;
    }
}
