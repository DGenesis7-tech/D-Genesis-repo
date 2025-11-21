package data.repositories;

import data.models.Ticket;
import java.util.List;

public interface TicketRepository {
    Ticket findById(int id);
    List<Ticket> findAll();
    void deleteById(int id);
    void delete(Ticket ticket);
    void deleteAll();
    int count();
    void updateTicket(Ticket ticket, Ticket newTicketData);
    void save(Ticket ticket);
}
