package be.kdg.prog6.parkplanning.PointOfInterest.deductStaffMember;

import be.kdg.prog6.parkplanning.PointOfInterest.deductStaffMember.ports.RemoveStaffMemberUseCase;
import be.kdg.prog6.parkplanning.PointOfInterest.deductStaffMember.ports.StaffMemberRemovedPort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DefaultRemoveStaffMemberUseCase implements RemoveStaffMemberUseCase {
    private final StaffMemberRemovedPort staffMemberRemovedPort;

    public DefaultRemoveStaffMemberUseCase(StaffMemberRemovedPort staffMemberRemovedPort) {
        this.staffMemberRemovedPort = staffMemberRemovedPort;
    }

    @Override
    public void removeStaffMember(UUID poiUuid, UUID staffMemberUuid) {
        staffMemberRemovedPort.removeStaffMember(poiUuid, staffMemberUuid);
    }
}
