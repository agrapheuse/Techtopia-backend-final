package be.kdg.prog6.visitorInformationSystem.adapters.out.JPAEntities;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="descriminatorColumn")
@Table(name="PointOfInterest")
public abstract class PointOfInterestJpaEntity {
    @Id
    @JdbcTypeCode(Types.VARCHAR)
    public UUID uuid;
    public String name;
    public String description;
    public float positionX;
    public float positionY;
    public String picture;
    public boolean open;
}
