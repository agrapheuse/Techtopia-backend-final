package be.kdg.prog6.visitorInformationSystem.adapters.out.JPAEntities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.util.UUID;

@Table
@Entity(name="FoodStand")
public class FoodStandJpaEntity {
    @Id
    @JdbcTypeCode(Types.VARCHAR)
    private UUID uuid;
    private String name;
    private String description;
    private float posX;
    private float posY;
    private String picturePath;
    private boolean open;
    private int queueTime;
    private String menu;

    public FoodStandJpaEntity(UUID uuid, String name, String description, float posX, float posY, String picturePath, boolean open, int queueTime, String menu) {
        this.uuid = uuid;
        this.name = name;
        this.description = description;
        this.posX = posX;
        this.posY = posY;
        this.picturePath = picturePath;
        this.open = open;
        this.queueTime = queueTime;
        this.menu = menu;
    }

    public FoodStandJpaEntity() {

    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
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

    public int getQueueTime() {
        return queueTime;
    }

    public void setQueueTime(int queueTime) {
        this.queueTime = queueTime;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }
}
