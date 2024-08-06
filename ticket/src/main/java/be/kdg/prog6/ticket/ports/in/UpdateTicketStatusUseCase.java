package be.kdg.prog6.ticket.ports.in;

import be.kdg.prog6.events.TicketStatusChangedEvent;

public interface UpdateTicketStatusUseCase {
    void updateTicket(TicketStatusChangedEvent ticketStatusChangedEvent);
}
