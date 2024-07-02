package be.kdg.prog6.visitorInformationSystem.domain;

import java.util.Objects;

public class Attraction extends PointOfInterest {
    private int minAge;

    public Attraction(PointOfInterestUUID uuid, String name, String description, float posX, float posY, String picturePath, boolean open, int minAge) {
        super.uuid = uuid;
        super.name = name;
        super.description = description;
        super.posX = posX;
        super.posY = posY;
        super.picturePath = picturePath;
        super.open = open;
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

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }
}
