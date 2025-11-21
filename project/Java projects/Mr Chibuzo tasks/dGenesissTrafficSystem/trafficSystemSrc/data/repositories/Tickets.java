package data.repositories;

import data.models.Ticket;

import java.util.ArrayList;

public class Tickets implements TicketRepository {
    private ArrayList<Ticket> tickets = new ArrayList<>();

    @Override
    public Ticket findById(int id) {
        if (id < 0 || id >= tickets.size()) return null;
        return tickets.get(id);
    }

    @Override
    public ArrayList<Ticket> findAll() {
        return new ArrayList<>(tickets);
    }

    @Override
    public void deleteById(int id) {
        if (id >= 0 && id < tickets.size()) {
            tickets.remove(id);
        }
    }

    @Override
    public void delete(Ticket ticket) {
        tickets.remove(ticket);
    }

    @Override
    public void deleteAll() {
        tickets.clear();
    }

    @Override
    public int count() {
        return tickets.size();
    }

    @Override
    public void updateTicket(Ticket ticket, Ticket newTicketData) {
        if (!tickets.contains(ticket) || ticket == null) {
            return;
        }

        ticket.setVehicle(newTicketData.getVehicle());
        ticket.setOffence(newTicketData.getOffence());

        ticket.setHasPaid(newTicketData.getOffence().getPrice(), newTicketData.getOffence());

        ticket.setIssuer(newTicketData.getIssuer());
        ticket.setDateOfBooking(newTicketData.getDateOfBooking());
        ticket.setDateOfPayment(newTicketData.getDateOfPayment());
    }


    @Override
    public void save(Ticket ticket) {
        tickets.add(ticket);
    }
}
