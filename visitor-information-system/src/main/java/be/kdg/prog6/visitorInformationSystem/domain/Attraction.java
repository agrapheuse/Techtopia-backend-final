package be.kdg.prog6.visitorInformationSystem.domain;

public class Attraction extends PointOfInterest {
    private int minHeight;

    public Attraction(PointOfInterestUUID uuid, String name, String description, float posX, float posY, String picturePath, boolean open, float queueTime, int minHeight) {
        super.setUuid(uuid);
        super.setName(name);
        super.setDescription(description);
        super.setPosX(posX);
        super.setPosY(posY);
        super.setPicturePath(picturePath);
        super.setOpen(open);
        super.setQueueTime(queueTime);
        this.minHeight = minHeight;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public void setMinHeight(int minHeight) {
        this.minHeight = minHeight;
    }
}
