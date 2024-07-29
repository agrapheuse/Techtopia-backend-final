package be.kdg.prog6.parkplanning.core;

import be.kdg.prog6.parkplanning.domain.PointOfInterest;
import be.kdg.prog6.parkplanning.domain.StaffMember;
import be.kdg.prog6.parkplanning.ports.in.AddStaffMemberCommand;
import be.kdg.prog6.parkplanning.ports.in.AddStaffMemberUseCase;
import be.kdg.prog6.parkplanning.ports.out.POILoadPort;
import be.kdg.prog6.parkplanning.ports.out.POIUpdatePort;
import be.kdg.prog6.parkplanning.ports.out.StaffMemberLoadPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultAddStaffMemberUseCase implements AddStaffMemberUseCase {
    private final StaffMemberLoadPort staffMemberLoadPort;
    private final POILoadPort poiLoadPort;
    private final POIUpdatePort poiUpdatePort;

    public static final Logger log = LoggerFactory.getLogger(DefaultAddStaffMemberUseCase.class);

    public DefaultAddStaffMemberUseCase(StaffMemberLoadPort staffMemberLoadPort, POILoadPort poiLoadPort, POIUpdatePort poiUpdatePort) {
        this.staffMemberLoadPort = staffMemberLoadPort;
        this.poiLoadPort = poiLoadPort;
        this.poiUpdatePort = poiUpdatePort;
    }

    @Override
    public void addStaffMember(AddStaffMemberCommand addStaffMemberCommand) {
        StaffMember staffMember = staffMemberLoadPort.loadStaffMember(addStaffMemberCommand.staffMemberUuid());
        PointOfInterest poi = poiLoadPort.loadPointOfInterest(addStaffMemberCommand.poiUuid());
        List<StaffMember> staff = poi.getStaff();
        staff.add(staffMember);
        poi.setStaff(staff);
        poiUpdatePort.updatePOI(poi);
    }
}
