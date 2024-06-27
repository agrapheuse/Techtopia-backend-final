package be.kdg.prog6.visitorInformationSystem.domain;

import java.util.Objects;
import java.util.UUID;

public class Attraction extends PointOfInterest {
    public record AttractionUUID(UUID uuid) { }
    private AttractionUUID uuid;
    private String name;
    private String description;
    private float posX;
    private float posY;
    private String picturePath;
    private boolean open;
    private int minAge;

    public Attraction(AttractionUUID uuid, String name, String description, float posX, float posY, String picturePath, boolean open, int minAge) {
        this.uuid = uuid;
        this.name = name;
        this.description = description;
        this.posX = posX;
        this.posY = posY;
        this.picturePath = picturePath;
        this.open = open;
        this.minAge = minAge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attraction that = (Attraction) o;
        return Float.compare(posX, that.posX) == 0 && Float.compare(posY, that.posY) == 0 && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, posX, posY);
    }

    public UUID getUuid() {
        return uuid.uuid;
    }

    public void setUuid(AttractionUUID uuid) {
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

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }
}
