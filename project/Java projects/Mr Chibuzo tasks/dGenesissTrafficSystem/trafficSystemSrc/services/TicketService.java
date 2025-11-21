package services;

import dtos.requests.IssueTicketRequest;
import dtos.responses.IssueTicketResponse;

public interface TicketService {
    IssueTicketResponse issue(IssueTicketRequest request);
}
