package be.kdg.prog6.parkplanning.ports.out;

import be.kdg.prog6.parkplanning.domain.StaffMember;

import java.util.UUID;

public interface StaffMemberAddedPort {
    void addStaffMember(UUID poiUuid, StaffMember staffMemberUuid);
}
