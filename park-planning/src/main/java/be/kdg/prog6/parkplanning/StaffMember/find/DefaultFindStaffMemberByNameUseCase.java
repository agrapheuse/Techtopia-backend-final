package be.kdg.prog6.parkplanning.StaffMember.find;

import be.kdg.prog6.parkplanning.StaffMember.StaffMember;
import be.kdg.prog6.parkplanning.StaffMember.find.ports.FindStaffMemberByNameUseCase;
import be.kdg.prog6.parkplanning.StaffMember.find.ports.StaffMemberLoadPort;
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
