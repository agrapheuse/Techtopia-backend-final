package be.kdg.prog6.parkgate.ports.out;

import be.kdg.prog6.parkgate.domain.Ticket;

public interface TicketUpdatedPort {
    void updateTicket(Ticket ticket);
}
