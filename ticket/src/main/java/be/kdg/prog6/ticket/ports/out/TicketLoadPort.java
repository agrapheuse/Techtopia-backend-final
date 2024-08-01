package be.kdg.prog6.ticket.ports.out;

import be.kdg.prog6.ticket.domain.Ticket;

import java.util.List;

public interface TicketLoadPort {
    List<Ticket> loadTicketsForEmail(String email);
}
