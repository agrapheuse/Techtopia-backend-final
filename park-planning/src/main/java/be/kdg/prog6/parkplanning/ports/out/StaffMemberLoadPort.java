package be.kdg.prog6.parkplanning.ports.out;

import be.kdg.prog6.parkplanning.domain.StaffMember;

import java.util.List;
import java.util.UUID;

public interface StaffMemberLoadPort {
    List<StaffMember> loadAllStaffMembers();
    List<StaffMember> loadStaffMembersByName(String name);
    StaffMember loadStaffMember(UUID uuid);
}
