package be.kdg.prog6.parkgate.ports.in;

import be.kdg.prog6.parkgate.domain.Ticket;

import java.util.UUID;

public interface LoadTicketUseCase {
    Ticket getTicket(UUID ticketUUID);
}
