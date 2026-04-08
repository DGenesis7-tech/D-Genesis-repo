package java.models;

public class Table {
    private String tableNumber;
    private int seatingCapacity;
    private String status;

    public Table(String tableNumber, int seatingCapacity) {
        this.tableNumber = tableNumber;
        this.seatingCapacity = seatingCapacity;
        this.status = "AVAILABLE";
    }

    public String getTableNumber() { return tableNumber; }
    public String getStatus() { return status; }

    public void occupy() { status = "OCCUPIED"; }
    public void free() { status = "AVAILABLE"; }
}