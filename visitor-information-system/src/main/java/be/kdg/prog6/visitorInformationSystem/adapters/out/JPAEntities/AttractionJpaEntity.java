package be.kdg.prog6.visitorInformationSystem.adapters.out.JPAEntities;

import be.kdg.prog6.visitorInformationSystem.domain.Attraction;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.util.UUID;

@Table
@Entity
public class AttractionJpaEntity {
    @Id
    @JdbcTypeCode(Types.VARCHAR)
    private UUID uuid;
    private String name;
    private String description;
    private float positionX;
    private float positionY;
    private String picture;
    private boolean open;
    private int minAge;

    public AttractionJpaEntity() {    }

    public AttractionJpaEntity(Attraction attraction) {
        this.uuid = attraction.getPointOfInterestUuid();
        this.name = attraction.getName();
        this.description = attraction.getDescription();
        this.positionX = attraction.getPosX();
        this.positionY = attraction.getPosY();
        this.picture = attraction.getPicturePath();
        this.open = attraction.isOpen();
        this.minAge = attraction.getMinAge();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPositionX() {
        return positionX;
    }

    public void setPositionX(float positionX) {
        this.positionX = positionX;
    }

    public float getPositionY() {
        return positionY;
    }

    public void setPositionY(float positionY) {
        this.positionY = positionY;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }
}
