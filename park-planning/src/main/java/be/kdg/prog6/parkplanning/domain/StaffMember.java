package be.kdg.prog6.parkplanning.domain;

import java.util.Objects;
import java.util.UUID;

public class StaffMember {
    public record StaffMemberUUID(UUID uuid) { }
    private StaffMemberUUID uuid;
    private PointOfInterest.PointOfInterestUUID poiUUID;
    private String name;

    public StaffMember(StaffMemberUUID uuid, PointOfInterest.PointOfInterestUUID poiUUID, String name) {
        this.uuid = uuid;
        this.poiUUID = poiUUID;
        this.name = name;
    }

    public StaffMemberUUID getUuid() {
        return uuid;
    }

    public void setUuid(StaffMemberUUID uuid) {
        this.uuid = uuid;
    }

    public PointOfInterest.PointOfInterestUUID getPoiUUID() {
        return poiUUID;
    }

    public void setPoiUUID(PointOfInterest.PointOfInterestUUID poiUUID) {
        this.poiUUID = poiUUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaffMember that = (StaffMember) o;
        return Objects.equals(uuid, that.uuid) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, name);
    }
}
