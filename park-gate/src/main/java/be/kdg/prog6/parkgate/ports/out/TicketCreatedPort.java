package be.kdg.prog6.parkgate.ports.out;

import be.kdg.prog6.parkgate.domain.Ticket;

public interface TicketCreatedPort {
    void createTicket(Ticket ticket);
}
