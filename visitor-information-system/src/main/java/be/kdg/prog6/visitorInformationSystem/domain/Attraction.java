package be.kdg.prog6.visitorInformationSystem.domain;

public class Attraction extends PointOfInterest {
    private int minAge;

    public Attraction(PointOfInterestUUID uuid, String name, String description, float posX, float posY, String picturePath, boolean open, int minAge) {
        super.setUuid(uuid);
        super.setName(name);
        super.setDescription(description);
        super.setPosX(posX);
        super.setPosY(posY);
        super.setPicturePath(picturePath);
        super.setOpen(open);
        this.minAge = minAge;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }
}
