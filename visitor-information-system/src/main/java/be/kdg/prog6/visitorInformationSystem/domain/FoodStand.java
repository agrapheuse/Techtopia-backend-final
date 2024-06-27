package be.kdg.prog6.visitorInformationSystem.domain;

import java.util.Objects;
import java.util.UUID;

public class FoodStand extends PointOfInterest {
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

    public UUID getUuid() {
        return uuid.uuid;
    }

    public void setUuid(FoodStandUuid uuid) {
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
