package be.kdg.prog6.visitorInformationSystem.PointOfInterest.Attraction;

import be.kdg.prog6.visitorInformationSystem.PointOfInterest.PointOfInterest;

import java.util.Objects;
import java.util.UUID;

public class Attraction implements PointOfInterest {
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

    @Override
    public UUID getPointOfInterestUuid() {
        return this.uuid.uuid;
    }

    @Override
    public void setPointOfInterestUuid(UUID pointOfInterestUuid) {
        this.uuid = new AttractionUUID(pointOfInterestUuid);
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
        return this.posX;
    }

    @Override
    public void setPosX(float posX) {
        this.posX = posX;
    }

    @Override
    public float getPosY() {
        return this.posY;
    }

    @Override
    public void setPosY(float posY) {
        this.posY = posY;
    }

    @Override
    public String getPicturePath() {
        return picturePath;
    }

    @Override
    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    @Override
    public boolean isOpen() {
        return open;
    }

    @Override
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
