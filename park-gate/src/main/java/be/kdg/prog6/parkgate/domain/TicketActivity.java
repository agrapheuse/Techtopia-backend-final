package be.kdg.prog6.parkgate.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public record TicketActivity(
        UUID ticketUUID,
        UUID poiUUID,
        ActivityType activityType,
        LocalDateTime dateTime
) {}
