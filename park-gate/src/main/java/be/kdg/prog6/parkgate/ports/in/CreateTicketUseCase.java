package be.kdg.prog6.parkgate.ports.in;

import be.kdg.prog6.events.TicketCreatedEvent;

public interface CreateTicketUseCase {
    void createTicket(TicketCreatedEvent ticketCreatedEvent);
}
