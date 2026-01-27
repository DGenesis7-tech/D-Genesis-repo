package dtos.responses;

public class SettleTicketResponse {
    private boolean done;
    private String message;

    public SettleTicketResponse() {}

    public SettleTicketResponse(boolean done, String message) {
        this.done = done;
        this.message = message;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
