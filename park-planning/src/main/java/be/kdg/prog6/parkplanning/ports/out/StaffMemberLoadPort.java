package be.kdg.prog6.parkplanning.ports.out;

import be.kdg.prog6.parkplanning.domain.StaffMember;

import java.util.List;

public interface StaffMemberLoadPort {
    List<StaffMember> loadAllStaffMembers();
    List<StaffMember> loadStaffMembersByName(String name);
}
