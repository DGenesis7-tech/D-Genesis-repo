package dtos.requests;

import data.models.Rank;

public class OfficerRequest {

    private String name;
    private Rank rank;

    public OfficerRequest() { }

    public OfficerRequest(String name, Rank rank) {
        this.name = name;
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public Rank getRank() {
        return rank;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }
}
