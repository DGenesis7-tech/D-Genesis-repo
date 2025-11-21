package data.models;

public class Officer {
    int id;
    String name;
    Rank rank;
    static int count = 1000;

    public Officer(String name, Rank rank) {
        this.name = name;
        this.rank = rank;
        setId(rank);
    }

    public Officer() {

    }

    @Override
    public String toString() {
        return "Officer{id=" + id + ", name='" + name + "', rank=" + rank + "}";
    }


    public int getId() {
        return id;
    }

    public void setId(Rank rank) {
        if (rank == Rank.PRIVATE) {
            this.id = count + 1;
        }
        if (rank == Rank.CONSTABLE) {
            this.id = count + 100 + 1;
        }
        if (rank == Rank.WARDEN) {
            this.id = count + 200 + 1;
        }
        if (rank == Rank.INSPECTOR) {
            this.id = count + 300 + 1;
        }
        if (rank == Rank.SUPERINTENDENT) {
            this.id = count + 400 + 1;
        }
        count++;
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
        setId(rank);
    }
}
