package controllers;

import dtos.requests.IssueTicketRequest;
import dtos.responses.IssueTicketResponse;
import services.TicketService;

public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public IssueTicketResponse issueTicket(IssueTicketRequest request) {
        return ticketService.issue(request);
    }
}
