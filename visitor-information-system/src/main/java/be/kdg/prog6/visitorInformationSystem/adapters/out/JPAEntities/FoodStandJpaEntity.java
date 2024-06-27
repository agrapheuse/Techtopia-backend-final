package be.kdg.prog6.visitorInformationSystem.adapters.out.JPAEntities;

import be.kdg.prog6.visitorInformationSystem.domain.FoodStand;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.UUID;

@Table
@Entity(name="FoodStand")
public class FoodStandJpaEntity extends PointOfInterestJpaEntity {
    private String menu;

    public FoodStandJpaEntity(FoodStand foodStand) {
        super.uuid = foodStand.getUuid();
        super.name = foodStand.getName();
        super.description = foodStand.getDescription();
        super.positionX = foodStand.getPositionX();
        super.positionY = foodStand.getPositionY();
        super.picture = foodStand.getPicturePath();
        super.open = foodStand.isOpen();
        this.menu = foodStand.getMenu();
    }

    public FoodStandJpaEntity() { }

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

    public String getPicturePath() {
        return super.picture;
    }

    public void setPicturePath(String picturePath) {
        super.picture = picturePath;
    }

    public boolean isOpen() {
        return super.open;
    }

    public void setOpen(boolean open) {
        super.open = open;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }
}
