package be.kdg.prog6.parkplanning.core;

import be.kdg.prog6.parkplanning.ports.in.RemoveStaffMemberCommand;
import be.kdg.prog6.parkplanning.ports.in.RemoveStaffMemberUseCase;
import be.kdg.prog6.parkplanning.ports.out.StaffMemberRemovedPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DefaultRemoveStaffMemberUseCase implements RemoveStaffMemberUseCase {
    private final StaffMemberRemovedPort staffMemberRemovedPort;
    public static final Logger log = LoggerFactory.getLogger(DefaultRemoveStaffMemberUseCase.class);

    public DefaultRemoveStaffMemberUseCase(StaffMemberRemovedPort staffMemberRemovedPort) {
        this.staffMemberRemovedPort = staffMemberRemovedPort;
    }

    @Override
    public void removeStaffMember(RemoveStaffMemberCommand removeStaffMemberCommand) {
        staffMemberRemovedPort.removeStaffMember(removeStaffMemberCommand.poiUuid(), removeStaffMemberCommand.staffMemberUuid());
    }
}
