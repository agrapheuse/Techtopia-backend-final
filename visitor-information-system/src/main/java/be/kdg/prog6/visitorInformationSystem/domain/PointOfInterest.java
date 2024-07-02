package be.kdg.prog6.visitorInformationSystem.domain;

import java.util.Objects;
import java.util.UUID;

public abstract class PointOfInterest {
    public record PointOfInterestUUID(UUID uuid) { }
    public PointOfInterestUUID uuid;
    public String name;
    public String description;
    public float posX;
    public float posY;
    public String picturePath;
    public boolean open;

    public PointOfInterestUUID getUuid() {
        return uuid;
    }

    public void setUuid(PointOfInterestUUID uuid) {
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

    public float getPosX() {
        return posX;
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }

    public float getPosY() {
        return posY;
    }

    public void setPosY(float posY) {
        this.posY = posY;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodStand that = (FoodStand) o;
        return Float.compare(posX, that.posX) == 0 && Float.compare(posY, that.posY) == 0 && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, posX, posY);
    }
}
