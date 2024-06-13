package be.kdg.prog6.visitorInformationSystem.PointOfInterest.FoodStand;

import be.kdg.prog6.visitorInformationSystem.PointOfInterest.PointOfInterest;

import java.util.Objects;
import java.util.UUID;

public class FoodStand implements PointOfInterest {
    public record FoodStandUuid(UUID uuid) { }
    private FoodStandUuid uuid;
    private String name;
    private String description;
    private float positionX;
    private float positionY;
    private String picturePath;
    private boolean open;
    private String menu;

    public FoodStand(FoodStandUuid uuid, String name, String description, float positionX, float positionY, String picturePath, boolean open, String menu) {
        this.uuid = uuid;
        this.name = name;
        this.description = description;
        this.positionX = positionX;
        this.positionY = positionY;
        this.picturePath = picturePath;
        this.open = open;
        this.menu = menu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodStand that = (FoodStand) o;
        return Float.compare(positionX, that.positionX) == 0 && Float.compare(positionY, that.positionY) == 0 && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, positionX, positionY);
    }

    @Override
    public UUID getPointOfInterestUuid() {
        return this.uuid.uuid;
    }

    @Override
    public void setPointOfInterestUuid(UUID pointOfInterestUuid) {
        this.uuid = new FoodStandUuid(pointOfInterestUuid);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public float getPosX() {
        return this.positionX;
    }

    @Override
    public void setPosX(float posX) {
        this.positionX = posX;
    }

    @Override
    public float getPosY() {
        return this.positionY;
    }

    @Override
    public void setPosY(float posY) {
        this.positionY = posY;
    }

    @Override
    public String getPicturePath() {
        return this.picturePath;
    }

    @Override
    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    @Override
    public boolean isOpen() {
        return true;
    }

    @Override
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
