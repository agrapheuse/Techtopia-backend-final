package be.kdg.prog6.parkplanning.PointOfInterest.addStaffMember.ports;

import java.util.UUID;

public interface StaffMemberAddedPort {
    void addStaffMember(UUID poiUuid, UUID staffMemberUuid);
}
