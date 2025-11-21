package dtos.requests;

public class ViewTicketRequest {
    private int ticketId;

    public ViewTicketRequest() {}

    public ViewTicketRequest(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }
}
