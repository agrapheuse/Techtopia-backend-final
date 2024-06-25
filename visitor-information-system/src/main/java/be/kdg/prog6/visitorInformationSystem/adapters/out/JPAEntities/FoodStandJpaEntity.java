package be.kdg.prog6.visitorInformationSystem.adapters.out.JPAEntities;

import be.kdg.prog6.visitorInformationSystem.domain.FoodStand;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.util.UUID;

@Table
@Entity
public class FoodStandJpaEntity {
    @Id
    @JdbcTypeCode(Types.VARCHAR)
    public UUID uuid;
    private String name;
    private String description;
    private float positionX;
    private float positionY;
    private String picturePath;
    private boolean open;
    private String menu;

    public FoodStandJpaEntity(FoodStand foodStand) {
        this.uuid = foodStand.getPointOfInterestUuid();
        this.name = foodStand.getName();
        this.description = foodStand.getDescription();
        this.positionX = foodStand.getPosX();
        this.positionY = foodStand.getPosY();
        this.picturePath = foodStand.getPicturePath();
        this.open = foodStand.isOpen();
        this.menu = foodStand.getMenu();
    }

    public FoodStandJpaEntity() { }

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

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }
}
