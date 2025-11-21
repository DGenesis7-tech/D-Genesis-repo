import data.models.Offence;
import data.models.Officer;
import data.models.Ticket;
import data.models.Vehicle;
import data.repositories.TicketRepository;
import data.repositories.Tickets;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class TicketsRepositoryTests {
    TicketRepository ticketRepo;
    Ticket ticket;

    @BeforeEach
    void setUp() {
        ticketRepo = new Tickets();
        ticket = new Ticket();
        ticket.setId(0);
        ticket.setVehicle(new Vehicle());
        ticket.setOffence(Offence.DRUNK_DRIVING);
        ticket.setIssuer(new Officer());
        ticket.setDateOfBooking(LocalDateTime.now());
    }

    @AfterEach
    void tearDown() {
        ticketRepo.deleteAll();
    }

    @Test
    void testToSaveTicket() {
        ticketRepo.save(ticket);
        assertEquals(1, ticketRepo.count());
        assertEquals(ticket, ticketRepo.findById(0));
    }

    @Test
    void testToUpdateTicket() {
        ticketRepo.save(ticket);
        Ticket newTicketData = new Ticket();
        newTicketData.setVehicle(new Vehicle());
        newTicketData.setOffence(Offence.UNDER_AGED);
        newTicketData.setIssuer(new Officer());
        newTicketData.setDateOfBooking(LocalDateTime.now());

        ticketRepo.updateTicket(ticket, newTicketData);
        Ticket updated = ticketRepo.findById(0);
        assertEquals(newTicketData.getVehicle(), updated.getVehicle());
        assertEquals(newTicketData.getIssuer(), updated.getIssuer());
        assertEquals(newTicketData.getOffence(), updated.getOffence());
    }

    @Test
    void testDeleteTicket() {
        ticketRepo.save(ticket);
        ticketRepo.delete(ticket);
        assertEquals(0, ticketRepo.count());
        assertTrue(ticketRepo.findAll().isEmpty());
    }

    @Test
    void testDeleteTicketById() {
        ticketRepo.save(ticket);
        ticketRepo.deleteById(0);
        assertEquals(0, ticketRepo.count());
    }

    @Test
    void testPaymentLessThanOffencePrice() {
        ticket.setHasPaid(ticket.getOffence().getDescription(), 1000);
        assertFalse(ticket.isHasPaid());
        assertNull(ticket.getDateOfPayment());
    }

    @Test
    void testPaymentIsEqualToOrAboveOffencePrice() {
        int price = ticket.getOffence().getPrice();
        ticket.setHasPaid(ticket.getOffence().getDescription(), price);
        assertTrue(ticket.isHasPaid());
        assertNotNull(ticket.getDateOfPayment());
    }
}
