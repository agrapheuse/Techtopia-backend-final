package be.kdg.prog6.parkgate.adapters.out.db.JPAEntities;

import be.kdg.prog6.parkgate.domain.Status;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.util.UUID;

@Entity
@Table(name="Ticket")
public class TicketJpaEntity {
    @Id
    @JdbcTypeCode(Types.VARCHAR)
    public UUID uuid;
    @Enumerated(EnumType.STRING)
    private Status status;

    public TicketJpaEntity(UUID uuid, Status status) {
        this.uuid = uuid;
        this.status = status;
    }

    public TicketJpaEntity() {
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
