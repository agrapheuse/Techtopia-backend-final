package be.kdg.prog6.parkplanning.core;

import be.kdg.prog6.parkplanning.ports.in.AddStaffMemberCommand;
import be.kdg.prog6.parkplanning.ports.in.AddStaffMemberUseCase;
import be.kdg.prog6.parkplanning.ports.out.StaffMemberAddedPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DefaultAddStaffMemberUseCase implements AddStaffMemberUseCase {
    private final StaffMemberAddedPort staffMemberAddedPort;

    public static final Logger log = LoggerFactory.getLogger(DefaultAddStaffMemberUseCase.class);

    public DefaultAddStaffMemberUseCase(StaffMemberAddedPort staffMemberAddedPort) {
        this.staffMemberAddedPort = staffMemberAddedPort;
    }

    @Override
    public void addStaffMember(AddStaffMemberCommand addStaffMemberCommand) {
        staffMemberAddedPort.addStaffMember(addStaffMemberCommand.poiUuid(), addStaffMemberCommand.staffMemberUuid());
    }
}
