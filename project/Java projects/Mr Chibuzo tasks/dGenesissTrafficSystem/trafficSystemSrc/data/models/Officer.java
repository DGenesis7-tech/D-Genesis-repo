package data.models;

public class Officer {
    int id;
    String name;
    Rank rank;
    int count = 1000;

    public Officer(int id, String name, Rank rank, int count) {
        this.id = id;
        this.name = name;
        this.rank = rank;
        this.count = count;

    }

    public Officer() {

    }

    public int getId() {
        return id;
    }

    public void setId(Rank rank) {
        if (getRank() == Rank.PRIVATE) {
            this.id = count + 1;
            count++;
        }
        if (getRank() == Rank.CONSTABLE) {
            this.id = count + 100 + 1;
            count++;
        }
        if (getRank() == Rank.WARDEN) {
            this.id = count + 200 + 1;
        }
        if (getRank() == Rank.INSPECTOR) {
            this.id = count + 300 + 1;
        }
        if (getRank() == Rank.SUPERINTENDENT) {
            this.id = count + 400 + 1;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }
}
