package be.kdg.prog6.parkplanning.core;

import be.kdg.prog6.parkplanning.domain.StaffMember;
import be.kdg.prog6.parkplanning.ports.in.FindStaffMemberByNameUseCase;
import be.kdg.prog6.parkplanning.ports.out.StaffMemberLoadPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultFindStaffMemberByNameUseCase implements FindStaffMemberByNameUseCase {
    private final StaffMemberLoadPort staffMemberLoadPort;
    public static final Logger log = LoggerFactory.getLogger(DefaultFindStaffMemberByNameUseCase.class);

    public DefaultFindStaffMemberByNameUseCase(StaffMemberLoadPort staffMemberLoadPort) {
        this.staffMemberLoadPort = staffMemberLoadPort;
    }

    @Override
    public List<StaffMember> findStaffMemberByName(String name) {
        log.debug("find staff members with name resembling {} called in use case", name);
        return staffMemberLoadPort.loadStaffMembersByName(name);
    }
}
