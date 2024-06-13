package be.kdg.prog6.parkplanning.PointOfInterest.deductStaffMember.ports;

import java.util.UUID;

public interface StaffMemberRemovedPort {
    void removeStaffMember(UUID poiUuid, UUID staffMemberUuid);
}
