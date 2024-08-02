package be.kdg.prog6.parkgate.adapters.out.db.JPAEntities;

import be.kdg.prog6.parkgate.domain.ActivityType;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="ticket_activity")
public class TicketActivityJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(Types.VARCHAR)
    public UUID uuid;

    @JdbcTypeCode(Types.VARCHAR)
    private UUID ticketUUID;

    @JdbcTypeCode(Types.VARCHAR)
    private UUID poiUUID;

    @Enumerated(EnumType.STRING)
    private ActivityType activityType;

    private LocalDateTime dateTime;

    public TicketActivityJpaEntity(UUID ticketUUID, UUID poiUUID, ActivityType activityType, LocalDateTime dateTime) {
        this.ticketUUID = ticketUUID;
        this.poiUUID = poiUUID;
        this.activityType = activityType;
        this.dateTime = dateTime;
    }

    public TicketActivityJpaEntity() {

    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getTicketUUID() {
        return ticketUUID;
    }

    public void setTicketUUID(UUID ticketUUID) {
        this.ticketUUID = ticketUUID;
    }

    public UUID getPoiUUID() {
        return poiUUID;
    }

    public void setPoiUUID(UUID poiUUID) {
        this.poiUUID = poiUUID;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
