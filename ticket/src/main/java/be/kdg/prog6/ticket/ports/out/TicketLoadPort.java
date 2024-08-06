package be.kdg.prog6.ticket.ports.out;

import be.kdg.prog6.ticket.domain.Ticket;

import java.util.List;
import java.util.UUID;

public interface TicketLoadPort {
    List<Ticket> loadTicketsForEmail(String email);
    Ticket loadTicketForUUID(UUID uuid);
}
