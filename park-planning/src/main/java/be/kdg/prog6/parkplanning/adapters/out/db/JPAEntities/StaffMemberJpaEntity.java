package be.kdg.prog6.parkplanning.adapters.out.db.JPAEntities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.util.UUID;

@Table
@Entity
public class StaffMemberJpaEntity {
    @Id
    @JdbcTypeCode(Types.VARCHAR)
    private UUID uuid;
    private UUID poiUUID;
    private String name;

    public StaffMemberJpaEntity(UUID uuid, String name, UUID poiUUID) {
        this.uuid = uuid;
        this.name = name;
        this.poiUUID = poiUUID;
    }

    public StaffMemberJpaEntity() {

    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getPoiUUID() {
        return poiUUID;
    }

    public void setPoiUUID(UUID poiUUID) {
        this.poiUUID = poiUUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
