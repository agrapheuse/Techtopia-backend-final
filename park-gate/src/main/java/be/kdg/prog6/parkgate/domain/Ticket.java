package be.kdg.prog6.parkgate.domain;

import be.kdg.prog6.enums.Status;

import java.util.UUID;

public class Ticket {
    public record TicketUUID(UUID uuid) { }
    private TicketUUID uuid;
    private Status status;

    public Ticket(TicketUUID uuid, Status status) {
        this.uuid = uuid;
        this.status = status;
    }

    public TicketUUID getUuid() {
        return uuid;
    }

    public void setUuid(TicketUUID uuid) {
        this.uuid = uuid;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
