package be.kdg.prog6.parkplanning.PointOfInterest;

import be.kdg.prog6.parkplanning.PointOfInterest.addStaffMember.ports.AddStaffMemberUseCase;
import be.kdg.prog6.parkplanning.PointOfInterest.close.ports.ClosePOIUseCase;
import be.kdg.prog6.parkplanning.PointOfInterest.deductStaffMember.ports.RemoveStaffMemberUseCase;
import be.kdg.prog6.parkplanning.PointOfInterest.open.ports.OpenPOIUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/pointOfInterest")
public class POIController {
    private final OpenPOIUseCase openPOIUseCase;
    private final ClosePOIUseCase closePOIUseCase;
    private final AddStaffMemberUseCase addStaffMemberUseCase;
    private final RemoveStaffMemberUseCase removeStaffMemberUseCase;

    public static final Logger log = LoggerFactory.getLogger(POIController.class);

    public POIController(OpenPOIUseCase openPOIUseCase, ClosePOIUseCase closePOIUseCase, AddStaffMemberUseCase addStaffMemberUseCase, RemoveStaffMemberUseCase removeStaffMemberUseCase) {
        this.openPOIUseCase = openPOIUseCase;
        this.closePOIUseCase = closePOIUseCase;
        this.addStaffMemberUseCase = addStaffMemberUseCase;
        this.removeStaffMemberUseCase = removeStaffMemberUseCase;
    }

    @PatchMapping("/open")
    public void openPOI(
            @RequestParam String uuid
    ) {
        openPOIUseCase.openPOI(UUID.fromString(uuid));
    }

    @PatchMapping("/close")
    public void closePOI(
            @RequestParam String uuid
    ) {
        closePOIUseCase.closePOI(UUID.fromString(uuid));
    }

    @PatchMapping("/addStaffMember")
    public void addStaffMember(
            @RequestParam String poiUuid,
            @RequestParam String staffMemberUuid
    ) {
        addStaffMemberUseCase.addStaffMember(UUID.fromString(poiUuid), UUID.fromString(staffMemberUuid));
    }

    @PatchMapping("/removeStaffMember")
    public void removeStaffMember(
            @RequestParam String poiUuid,
            @RequestParam String staffMemberUuid
    ) {
        removeStaffMemberUseCase.removeStaffMember(UUID.fromString(poiUuid), UUID.fromString(staffMemberUuid));
    }
}
