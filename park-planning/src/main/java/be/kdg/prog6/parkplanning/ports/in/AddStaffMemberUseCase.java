package be.kdg.prog6.parkplanning.ports.in;

import java.util.UUID;

public interface AddStaffMemberUseCase {
    void addStaffMember(UUID poiUuid, UUID staffMemberUuid);
}
