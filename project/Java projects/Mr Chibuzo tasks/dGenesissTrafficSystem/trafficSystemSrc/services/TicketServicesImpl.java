package services;

import dtos.requests.IssueTicketRequest;
import dtos.responses.IssueTicketResponse;
import data.models.*;
import data.repositories.OfficerRepository;
import data.repositories.Officers;
import data.repositories.TicketRepository;
import data.repositories.Tickets;
import utils.Mapper;

import java.time.LocalDateTime;

public class TicketServicesImpl implements TicketService {

    private TicketRepository ticketRepo = new Tickets();
    private OfficerRepository officerRepo = new Officers();

    @Override
    public IssueTicketResponse issue(IssueTicketRequest request) {

        Officer officer = officerRepo.findById(request.getOfficerId());
        if (officer == null) {
            return new IssueTicketResponse(false, "Officer not found");
        }

        Offence offence = Offence.fromDescription(request.getOffenceDescription());
        if (offence == null) {
            return new IssueTicketResponse(false, "Offence not found");
        }

        Vehicle vehicle = new Vehicle();
        vehicle.setId(request.getVehicleId());

        Ticket ticket = Mapper.mapIssueTicketRequestToTicket(request, vehicle, officer, offence);
        ticket.setDateOfBooking(LocalDateTime.now());

        ticketRepo.save(ticket);

        return new IssueTicketResponse(ticket.isHasPaid(), "Ticket issued successfully");
    }
}
