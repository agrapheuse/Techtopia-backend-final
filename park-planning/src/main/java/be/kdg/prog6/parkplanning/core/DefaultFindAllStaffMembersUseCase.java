package be.kdg.prog6.parkplanning.core;

import be.kdg.prog6.parkplanning.domain.StaffMember;
import be.kdg.prog6.parkplanning.ports.in.FindAllStaffMembersUseCase;
import be.kdg.prog6.parkplanning.ports.out.StaffMemberLoadPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultFindAllStaffMembersUseCase implements FindAllStaffMembersUseCase {
    private final StaffMemberLoadPort staffMemberLoadPort;
    public static final Logger log = LoggerFactory.getLogger(DefaultFindAllStaffMembersUseCase.class);

    public DefaultFindAllStaffMembersUseCase(StaffMemberLoadPort staffMemberLoadPort) {
        this.staffMemberLoadPort = staffMemberLoadPort;
    }

    @Override
    public List<StaffMember> findAllStaffMembers() {
        return staffMemberLoadPort.loadAllStaffMembers();
    }
}
