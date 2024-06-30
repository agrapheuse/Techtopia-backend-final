package be.kdg.prog6.parkplanning.ports.out;

import java.util.UUID;

public interface StaffMemberRemovedPort {
    void removeStaffMember(UUID poiUuid, UUID staffMemberUuid);
}
