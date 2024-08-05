package be.kdg.prog6.parkplanning.ports.in;

import be.kdg.prog6.parkplanning.domain.StaffMember;

import java.util.List;
import java.util.UUID;

public interface FindStaffMemberOfPOIUseCase {
    List<StaffMember> findStaffMemberByPOI(UUID uuid);
}
