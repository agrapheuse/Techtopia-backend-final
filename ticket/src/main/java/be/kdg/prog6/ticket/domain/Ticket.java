package be.kdg.prog6.ticket.domain;

import java.time.LocalDate;
import java.util.UUID;

public class Ticket {
    public record TicketUuid(UUID uuid) {}
    private TicketUuid uuid;
    private LocalDate date;
    private Person visitor;
    private TicketOption option;
    private TicketAgeType ageType;
    private String email;

    public Ticket(TicketUuid uuid, LocalDate date, Person visitor, TicketOption option, TicketAgeType ageType, String email) {
        this.uuid = uuid;
        this.date = date;
        this.visitor = visitor;
        this.option = option;
        this.ageType = ageType;
        this.email = email;
    }

    public TicketUuid getUuid() {
        return uuid;
    }

    public void setUuid(TicketUuid uuid) {
        this.uuid = uuid;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Person getVisitor() {
        return visitor;
    }

    public void setVisitor(Person visitor) {
        this.visitor = visitor;
    }

    public TicketOption getOption() {
        return option;
    }

    public void setOption(TicketOption option) {
        this.option = option;
    }

    public TicketAgeType getAgeType() {
        return ageType;
    }

    public void setAgeType(TicketAgeType ageType) {
        this.ageType = ageType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
