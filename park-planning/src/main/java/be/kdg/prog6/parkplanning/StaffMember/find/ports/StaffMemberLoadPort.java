package be.kdg.prog6.parkplanning.StaffMember.find.ports;

import be.kdg.prog6.parkplanning.StaffMember.StaffMember;

import java.util.List;

public interface StaffMemberLoadPort {
    List<StaffMember> loadAllStaffMembers();
    List<StaffMember> loadStaffMembersByName(String name);
}
