package be.kdg.prog6.parkplanning.core;

import be.kdg.prog6.parkplanning.domain.StaffMember;
import be.kdg.prog6.parkplanning.ports.in.FindStaffMemberByNameUseCase;
import be.kdg.prog6.parkplanning.ports.out.StaffMemberLoadPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultFindStaffMemberByNameUseCase implements FindStaffMemberByNameUseCase {
    private final StaffMemberLoadPort staffMemberLoadPort;

    public DefaultFindStaffMemberByNameUseCase(StaffMemberLoadPort staffMemberLoadPort) {
        this.staffMemberLoadPort = staffMemberLoadPort;
    }

    @Override
    public List<StaffMember> findStaffMemberByName(String name) {
        return staffMemberLoadPort.loadStaffMembersByName(name);
    }
}
