package be.kdg.prog6.parkplanning.ports.in;

import be.kdg.prog6.parkplanning.domain.StaffMember;

import java.util.List;

public interface FindStaffMemberByNameUseCase {
    List<StaffMember> findStaffMemberByName(String name);
}
