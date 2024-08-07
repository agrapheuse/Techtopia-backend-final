package be.kdg.prog6.parkplanning.domain;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class PointOfInterest {
    public record PointOfInterestUUID(UUID uuid) { }
    private PointOfInterestUUID uuid;
    private List<StaffMember> staff;
    private boolean open;
    private int amountOfPeople;

    public PointOfInterest(PointOfInterestUUID uuid, List<StaffMember> staff, boolean open, int amountOfPeople) {
        this.uuid = uuid;
        this.staff = staff;
        this.open = open;
        this.amountOfPeople = amountOfPeople;
    }

    public PointOfInterestUUID getUuid() {
        return uuid;
    }

    public void setUuid(PointOfInterestUUID uuid) {
        this.uuid = uuid;
    }

    public List<StaffMember> getStaff() {
        return staff;
    }

    public void setStaff(List<StaffMember> staff) {
        this.staff = staff;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public int getAmountOfPeople() {
        return amountOfPeople;
    }

    public void setAmountOfPeople(int amountOfPeople) {
        this.amountOfPeople = amountOfPeople;
    }

    public void addPerson() {
        this.amountOfPeople += 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PointOfInterest that = (PointOfInterest) o;
        return open == that.open && Objects.equals(uuid, that.uuid) && Objects.equals(staff, that.staff);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, staff, open);
    }
}
