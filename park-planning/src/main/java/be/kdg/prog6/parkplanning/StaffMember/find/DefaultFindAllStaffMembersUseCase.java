package be.kdg.prog6.parkplanning.StaffMember.find;

import be.kdg.prog6.parkplanning.StaffMember.StaffMember;
import be.kdg.prog6.parkplanning.StaffMember.find.ports.FindAllStaffMembersUseCase;
import be.kdg.prog6.parkplanning.StaffMember.find.ports.StaffMemberLoadPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultFindAllStaffMembersUseCase implements FindAllStaffMembersUseCase {
    private final StaffMemberLoadPort staffMemberLoadPort;

    public DefaultFindAllStaffMembersUseCase(StaffMemberLoadPort staffMemberLoadPort) {
        this.staffMemberLoadPort = staffMemberLoadPort;
    }

    @Override
    public List<StaffMember> findAllStaffMembers() {
        return staffMemberLoadPort.loadAllStaffMembers();
    }
}
