package be.kdg.prog6.visitorInformationSystem.domain;

import java.util.Objects;
import java.util.UUID;

public abstract class PointOfInterest {
    public record PointOfInterestUUID(UUID uuid) { }
    private PointOfInterestUUID uuid;
    private String name;
    private String description;
    private float posX;
    private float posY;
    private String picturePath;
    private float queueTime;
    private boolean open;

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

    public float getQueueTime() {
        return queueTime;
    }

    public void setQueueTime(float queueTime) {
        this.queueTime = queueTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PointOfInterest that = (PointOfInterest) o;
        return Objects.equals(uuid, that.uuid) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, name);
    }
}
