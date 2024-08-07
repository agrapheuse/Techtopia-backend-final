package be.kdg.prog6.parkgate.ports.in;

import java.util.UUID;

public record VisitPOICommand(UUID ticketUUID, UUID poiUUID) {
}
