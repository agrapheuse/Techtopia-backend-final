package be.kdg.prog6.parkgate.ports.out;

import be.kdg.prog6.parkgate.domain.Ticket;

import java.util.UUID;

public interface TicketLoadedPort {
    Ticket getTicket(UUID ticketUUID);
}
