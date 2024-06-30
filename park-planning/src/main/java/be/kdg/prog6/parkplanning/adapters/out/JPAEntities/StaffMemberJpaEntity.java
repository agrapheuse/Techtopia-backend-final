package be.kdg.prog6.parkplanning.adapters.out.JPAEntities;

import be.kdg.prog6.parkplanning.domain.StaffMember;
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
    private String name;

    public StaffMemberJpaEntity(StaffMember staffMember) {
        this.uuid = staffMember.getUuid().uuid();
        this.name = staffMember.getName();
    }

    public StaffMemberJpaEntity() {

    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
