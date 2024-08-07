package be.kdg.prog6.visitorInformationSystem.adapters.out.JPAEntities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.util.UUID;

@Entity
@Table(name="Attraction")
public class AttractionJpaEntity {
    @Id
    @JdbcTypeCode(Types.VARCHAR)
    private UUID uuid;
    private String name;
    private String description;
    private float posX;
    private float posY;
    private String picturePath;
    private boolean open;
    private float queueTime;
    private int minHeight;

    public AttractionJpaEntity() {    }

    public AttractionJpaEntity(UUID uuid, String name, String description, float posX, float posY, String picturePath, boolean open, float queueTime, int minHeight) {
        this.uuid = uuid;
        this.name = name;
        this.description = description;
        this.posX = posX;
        this.posY = posY;
        this.picturePath = picturePath;
        this.open = open;
        this.queueTime = queueTime;
        this.minHeight = minHeight;
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

    public float getQueueTime() {
        return queueTime;
    }

    public void setQueueTime(float queueTime) {
        this.queueTime = queueTime;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public void setMinHeight(int minAge) {
        this.minHeight = minAge;
    }
}
