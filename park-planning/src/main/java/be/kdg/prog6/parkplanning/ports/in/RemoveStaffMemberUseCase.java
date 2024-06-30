package be.kdg.prog6.parkplanning.ports.in;

import java.util.UUID;

public interface RemoveStaffMemberUseCase {
    void removeStaffMember(UUID poiUuid, UUID staffMemberUuid);
}
