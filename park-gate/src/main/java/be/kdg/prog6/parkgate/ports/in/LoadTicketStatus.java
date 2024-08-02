package be.kdg.prog6.parkgate.ports.in;

import be.kdg.prog6.parkgate.domain.Status;

import java.util.UUID;

public interface LoadTicketStatus {
    Status getTicketStatus(UUID ticketUUID);
}
