package be.kdg.prog6.visitorInformationSystem.domain;

public class FoodStand extends PointOfInterest {
    private String menu;

    public FoodStand(PointOfInterestUUID uuid, String name, String description, float positionX, float positionY, String picturePath, boolean open, float queueTime, String menu) {
        super.setUuid(uuid);
        super.setName(name);
        super.setDescription(description);
        super.setPosX(positionX);
        super.setPosY(positionY);
        super.setOpen(open);
        super.setPicturePath(picturePath);
        super.setQueueTime(queueTime);
        this.menu = menu;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }
}
