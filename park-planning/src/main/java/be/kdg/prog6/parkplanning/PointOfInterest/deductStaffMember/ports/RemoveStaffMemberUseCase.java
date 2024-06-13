package be.kdg.prog6.parkplanning.PointOfInterest.deductStaffMember.ports;

import java.util.UUID;

public interface RemoveStaffMemberUseCase {
    void removeStaffMember(UUID poiUuid, UUID staffMemberUuid);
}
