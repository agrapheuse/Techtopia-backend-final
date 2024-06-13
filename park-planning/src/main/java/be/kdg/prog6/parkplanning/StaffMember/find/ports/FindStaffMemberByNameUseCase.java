package be.kdg.prog6.parkplanning.StaffMember.find.ports;

import be.kdg.prog6.parkplanning.StaffMember.StaffMember;

import java.util.List;

public interface FindStaffMemberByNameUseCase {
    List<StaffMember> findStaffMemberByName(String name);
}
