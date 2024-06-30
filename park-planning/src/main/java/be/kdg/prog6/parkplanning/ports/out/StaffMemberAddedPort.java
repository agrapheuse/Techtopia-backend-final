package be.kdg.prog6.parkplanning.ports.out;

import java.util.UUID;

public interface StaffMemberAddedPort {
    void addStaffMember(UUID poiUuid, UUID staffMemberUuid);
}
