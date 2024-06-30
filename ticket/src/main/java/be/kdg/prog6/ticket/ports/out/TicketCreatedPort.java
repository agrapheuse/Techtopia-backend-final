package be.kdg.prog6.ticket.ports.out;

import be.kdg.prog6.ticket.domain.Ticket;

public interface TicketCreatedPort {
    void createTicket(Ticket ticket);
}
