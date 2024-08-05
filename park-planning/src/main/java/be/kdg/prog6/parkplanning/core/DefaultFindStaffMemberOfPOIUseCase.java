package be.kdg.prog6.parkplanning.core;

import be.kdg.prog6.parkplanning.domain.PointOfInterest;
import be.kdg.prog6.parkplanning.domain.StaffMember;
import be.kdg.prog6.parkplanning.ports.in.FindStaffMemberOfPOIUseCase;
import be.kdg.prog6.parkplanning.ports.out.POILoadPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DefaultFindStaffMemberOfPOIUseCase implements FindStaffMemberOfPOIUseCase {
    public static final Logger log = LoggerFactory.getLogger(DefaultRemoveStaffMemberUseCase.class);
    private final POILoadPort poiLoadPort;

    public DefaultFindStaffMemberOfPOIUseCase(POILoadPort poiLoadPort) {
        this.poiLoadPort = poiLoadPort;
    }

    @Override
    public List<StaffMember> findStaffMemberByPOI(UUID uuid) {
        log.debug("finding staff members of poi {} in DefaultFindStaffMemberOfPOIUseCase", uuid);
        PointOfInterest poi = poiLoadPort.loadPointOfInterest(uuid);
        return poi.getStaff();
    }
}
