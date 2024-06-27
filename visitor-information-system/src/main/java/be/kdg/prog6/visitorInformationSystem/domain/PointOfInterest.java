package be.kdg.prog6.visitorInformationSystem.domain;

import java.util.UUID;

public abstract class PointOfInterest {
    public record PointOfInterestUUID(UUID uuid) { }
    private Attraction.AttractionUUID uuid;
    private String name;
    private String description;
    private float posX;
    private float posY;
    private String picturePath;
    private boolean open;
}
