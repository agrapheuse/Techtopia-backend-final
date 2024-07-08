package be.kdg.prog6.ticket.adapters.out.db.JPAEntities;

import be.kdg.prog6.ticket.domain.TicketAgeType;
import be.kdg.prog6.ticket.domain.TicketOption;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="Ticket")
public class TicketJpaEntity {
    @Id
    @JdbcTypeCode(Types.VARCHAR)
    public UUID uuid;
    private LocalDate date;
    @OneToOne
    private PersonJpaEntity visitor;
    @Enumerated(EnumType.STRING)
    private TicketOption ticketOption;
    @Enumerated(EnumType.STRING)
    private TicketAgeType ageType;
    private String email;

    public TicketJpaEntity(UUID uuid, LocalDate date, PersonJpaEntity visitor, TicketOption ticketOption, TicketAgeType ageType, String email) {
        this.uuid = uuid;
        this.date = date;
        this.visitor = visitor;
        this.ticketOption = ticketOption;
        this.ageType = ageType;
        this.email = email;
    }

    public TicketJpaEntity() {
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public PersonJpaEntity getVisitor() {
        return visitor;
    }

    public void setVisitor(PersonJpaEntity visitor) {
        this.visitor = visitor;
    }

    public TicketOption getTicketOption() {
        return ticketOption;
    }

    public void setTicketOption(TicketOption option) {
        this.ticketOption = option;
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
