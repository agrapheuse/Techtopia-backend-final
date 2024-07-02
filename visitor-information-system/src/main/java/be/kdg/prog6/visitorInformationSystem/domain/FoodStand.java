package be.kdg.prog6.visitorInformationSystem.domain;

public class FoodStand extends PointOfInterest {
    private String menu;

    public FoodStand(PointOfInterestUUID uuid, String name, String description, float positionX, float positionY, String picturePath, boolean open, String menu) {
        super.uuid = uuid;
        super.name = name;
        super.description = description;
        super.posX = positionX;
        super.posY = positionY;
        super.picturePath = picturePath;
        super.open = open;
        this.menu = menu;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }
}
