package dtos.responses;

public class IssueTicketResponse {
    private boolean done;
    private String message;

    public IssueTicketResponse() {}

    public IssueTicketResponse(boolean done, String message) {
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
