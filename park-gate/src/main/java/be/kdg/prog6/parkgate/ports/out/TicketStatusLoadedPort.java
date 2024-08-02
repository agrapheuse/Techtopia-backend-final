package be.kdg.prog6.parkgate.ports.out;

import be.kdg.prog6.parkgate.domain.Status;

import java.util.UUID;

public interface TicketStatusLoadedPort {
    Status getTicketStatus(UUID ticketUUID);
}
