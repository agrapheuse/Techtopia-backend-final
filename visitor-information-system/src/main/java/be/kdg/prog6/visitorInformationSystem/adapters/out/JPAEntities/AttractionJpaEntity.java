package be.kdg.prog6.visitorInformationSystem.adapters.out.JPAEntities;

import be.kdg.prog6.visitorInformationSystem.domain.Attraction;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name="Attraction")
public class AttractionJpaEntity extends PointOfInterestJpaEntity {
    private int minAge;

    public AttractionJpaEntity() {    }

    public AttractionJpaEntity(Attraction attraction) {
        super.uuid = attraction.getUuid();
        super.name = attraction.getName();
        super.description = attraction.getDescription();
        super.positionX = attraction.getPosX();
        super.positionY = attraction.getPosX();
        super.picture = attraction.getPicturePath();
        super.open = attraction.isOpen();
        this.minAge = attraction.getMinAge();
    }

    public UUID getUuid() {
        return super.uuid;
    }

    public void setUuid(UUID uuid) {
        super.uuid = uuid;
    }

    public String getName() {
        return super.name;
    }

    public void setName(String name) {
        super.name = name;
    }

    public String getDescription() {
        return super.description;
    }

    public void setDescription(String description) {
        super.description = description;
    }

    public float getPositionX() {
        return super.positionX;
    }

    public void setPositionX(float positionX) {
        super.positionX = positionX;
    }

    public float getPositionY() {
        return super.positionY;
    }

    public void setPositionY(float positionY) {
        super.positionY = positionY;
    }

    public String getPicture() {
        return super.picture;
    }

    public void setPicture(String picture) {
        super.picture = picture;
    }

    public boolean isOpen() {
        return super.open;
    }

    public void setOpen(boolean open) {
        super.open = open;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }
}
