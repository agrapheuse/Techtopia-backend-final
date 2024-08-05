package be.kdg.prog6.parkplanning.core;

import be.kdg.prog6.parkplanning.domain.PointOfInterest;
import be.kdg.prog6.parkplanning.domain.StaffMember;
import be.kdg.prog6.parkplanning.exceptions.StaffMemberNotInPOIException;
import be.kdg.prog6.parkplanning.ports.in.RemoveStaffMemberCommand;
import be.kdg.prog6.parkplanning.ports.in.RemoveStaffMemberUseCase;
import be.kdg.prog6.parkplanning.ports.out.POILoadPort;
import be.kdg.prog6.parkplanning.ports.out.POIUpdatePort;
import be.kdg.prog6.parkplanning.ports.out.StaffMemberLoadPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultRemoveStaffMemberUseCase implements RemoveStaffMemberUseCase {
    private final StaffMemberLoadPort staffMemberLoadPort;
    private final POILoadPort poiLoadPort;
    private final POIUpdatePort poiUpdatePort;

    public static final Logger log = LoggerFactory.getLogger(DefaultRemoveStaffMemberUseCase.class);

    public DefaultRemoveStaffMemberUseCase(StaffMemberLoadPort staffMemberLoadPort, POILoadPort poiLoadPort, POIUpdatePort poiUpdatePort) {
        this.staffMemberLoadPort = staffMemberLoadPort;
        this.poiLoadPort = poiLoadPort;
        this.poiUpdatePort = poiUpdatePort;
    }

    @Override
    public void removeStaffMember(RemoveStaffMemberCommand removeStaffMemberCommand) {
        log.debug("removing staff member {} in DefaultAddStaffMemberUseCase", removeStaffMemberCommand.staffMemberUuid());
        PointOfInterest poi = poiLoadPort.loadPointOfInterest(removeStaffMemberCommand.poiUuid());
        StaffMember staffMember = staffMemberLoadPort.loadStaffMember(removeStaffMemberCommand.staffMemberUuid());
        List<StaffMember> staff = poi.getStaff();
        if (staff.contains(staffMember)) {
            staff.remove(staffMember);
            poi.setStaff(staff);
            poiUpdatePort.updatePOI(poi);
        } else {
            throw new StaffMemberNotInPOIException();
        }
    }
}
