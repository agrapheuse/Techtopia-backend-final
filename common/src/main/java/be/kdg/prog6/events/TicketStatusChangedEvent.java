package be.kdg.prog6.events;

import be.kdg.prog6.enums.Status;

import java.util.UUID;

public record TicketStatusChangedEvent(UUID TicketUUID, Status status) implements Event {
}
