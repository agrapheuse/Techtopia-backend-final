package be.kdg.prog6.ticket.ports.out;

import be.kdg.prog6.ticket.domain.Ticket;

public interface TicketUpdatedPort {
    void updateTicket(Ticket ticket);
}
