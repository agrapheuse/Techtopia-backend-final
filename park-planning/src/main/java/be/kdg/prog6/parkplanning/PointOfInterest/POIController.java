package be.kdg.prog6.parkplanning.PointOfInterest;

import be.kdg.prog6.parkplanning.PointOfInterest.addStaffMember.ports.AddStaffMemberUseCase;
import be.kdg.prog6.parkplanning.PointOfInterest.close.ports.ClosePOIUseCase;
import be.kdg.prog6.parkplanning.PointOfInterest.deductStaffMember.ports.RemoveStaffMemberUseCase;
import be.kdg.prog6.parkplanning.PointOfInterest.open.ports.OpenPOIUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/pointOfInterest")
public class POIController {
    private final OpenPOIUseCase openPOIUseCase;
    private final ClosePOIUseCase closePOIUseCase;
    private final AddStaffMemberUseCase addStaffMemberUseCase;
    private final RemoveStaffMemberUseCase removeStaffMemberUseCase;

    public POIController(OpenPOIUseCase openPOIUseCase, ClosePOIUseCase closePOIUseCase, AddStaffMemberUseCase addStaffMemberUseCase, RemoveStaffMemberUseCase removeStaffMemberUseCase) {
        this.openPOIUseCase = openPOIUseCase;
        this.closePOIUseCase = closePOIUseCase;
        this.addStaffMemberUseCase = addStaffMemberUseCase;
        this.removeStaffMemberUseCase = removeStaffMemberUseCase;
    }

    @GetMapping("/open")
    public void openPOI(
            @RequestParam String uuid
    ) {
        openPOIUseCase.openPOI(UUID.fromString(uuid));
    }

    @GetMapping("/close")
    public void closePOI(
            @RequestParam String uuid
    ) {
        closePOIUseCase.closePOI(UUID.fromString(uuid));
    }

    @GetMapping("/addStaffMember")
    public void addStaffMember(
            @RequestParam String poiUuid,
            @RequestParam String staffMemberUuid
    ) {
        addStaffMemberUseCase.addStaffMember(UUID.fromString(poiUuid), UUID.fromString(staffMemberUuid));
    }

    @GetMapping("/removeStaffMember")
    public void removeStaffMember(
            @RequestParam String poiUuid,
            @RequestParam String staffMemberUuid
    ) {
        removeStaffMemberUseCase.removeStaffMember(UUID.fromString(poiUuid), UUID.fromString(staffMemberUuid));
    }
}
