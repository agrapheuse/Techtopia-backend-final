package be.kdg.prog6.parkplanning.core;

import be.kdg.prog6.parkplanning.domain.PointOfInterest;
import be.kdg.prog6.parkplanning.domain.StaffMember;
import be.kdg.prog6.parkplanning.ports.in.UpdateStaffMemberCommand;
import be.kdg.prog6.parkplanning.ports.in.UpdateStaffMembersUseCase;
import be.kdg.prog6.parkplanning.ports.out.POILoadPort;
import be.kdg.prog6.parkplanning.ports.out.POIUpdatePort;
import be.kdg.prog6.parkplanning.ports.out.StaffMemberLoadPort;
import be.kdg.prog6.parkplanning.ports.out.StaffMemberUpdatedPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultUpdateStaffMembersUseCase implements UpdateStaffMembersUseCase {
    public static final Logger log = LoggerFactory.getLogger(DefaultUpdateStaffMembersUseCase.class);

    private final POILoadPort poiLoadPort;
    private final StaffMemberLoadPort staffMemberLoadPort;
    private final StaffMemberUpdatedPort staffMemberUpdatedPort;
    private final POIUpdatePort poiUpdatePort;

    public DefaultUpdateStaffMembersUseCase(POILoadPort poiLoadPort, StaffMemberLoadPort staffMemberLoadPort, StaffMemberUpdatedPort staffMemberUpdatedPort, POIUpdatePort poiUpdatePort) {
        this.poiLoadPort = poiLoadPort;
        this.staffMemberLoadPort = staffMemberLoadPort;
        this.staffMemberUpdatedPort = staffMemberUpdatedPort;
        this.poiUpdatePort = poiUpdatePort;
    }

    @Override
    public void updateStaffMembers(UpdateStaffMemberCommand updateStaffMemberCommand) {
        log.info("updating poi {} and assigning staffMembers {} called in use case", updateStaffMemberCommand.poiUuid(), updateStaffMemberCommand.staffMemberUuids());
        PointOfInterest poi = poiLoadPort.loadPointOfInterest(updateStaffMemberCommand.poiUuid());
        poi.getStaff().forEach(staff -> {
            staff.setPoiUUID(new PointOfInterest.PointOfInterestUUID(null));
            staffMemberUpdatedPort.updateStaffMember(staff);
        });
        List<StaffMember> staffMemberList = updateStaffMemberCommand.staffMemberUuids().stream().map(uuid -> {
            StaffMember staffMember = staffMemberLoadPort.loadStaffMember(uuid);
            staffMember.setPoiUUID(poi.getUuid());
            staffMemberUpdatedPort.updateStaffMember(staffMember);
            return staffMember;
        }).toList();
        poi.setStaff(staffMemberList);
        poiUpdatePort.updatePOI(poi);
    }
}
