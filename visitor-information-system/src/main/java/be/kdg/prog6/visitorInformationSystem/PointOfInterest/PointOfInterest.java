package be.kdg.prog6.visitorInformationSystem.PointOfInterest;

import java.util.UUID;

public interface PointOfInterest {
    UUID getPointOfInterestUuid();

    void setPointOfInterestUuid(UUID pointOfInterestUuid);

    String getName();

    void setName(String name);

    String getDescription();

    void setDescription(String description);

    float getPosX();

    void setPosX(float posX);

    float getPosY();

    void setPosY(float posY);

    String getPicturePath();

    void setPicturePath(String picturePath);

    boolean isOpen();

    void setOpen(boolean open);
}
