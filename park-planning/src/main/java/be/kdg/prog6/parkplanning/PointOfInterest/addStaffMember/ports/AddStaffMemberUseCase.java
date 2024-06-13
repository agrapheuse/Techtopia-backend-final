package be.kdg.prog6.parkplanning.PointOfInterest.addStaffMember.ports;

import java.util.UUID;

public interface AddStaffMemberUseCase {
    void addStaffMember(UUID poiUuid, UUID staffMemberUuid);
}
