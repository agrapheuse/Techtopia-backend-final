package be.kdg.prog6.parkplanning.adapters.in.web;

import be.kdg.prog6.parkplanning.ports.in.AddStaffMemberUseCase;
import be.kdg.prog6.parkplanning.ports.in.RemoveStaffMemberUseCase;
import be.kdg.prog6.parkplanning.ports.in.ChangePOIOpenStatusUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/pointOfInterest")
public class POIController {
    private final AddStaffMemberUseCase addStaffMemberUseCase;
    private final RemoveStaffMemberUseCase removeStaffMemberUseCase;
    private final ChangePOIOpenStatusUseCase changePOIOpenStatusUseCase;

    public static final Logger log = LoggerFactory.getLogger(POIController.class);

    public POIController(AddStaffMemberUseCase addStaffMemberUseCase, RemoveStaffMemberUseCase removeStaffMemberUseCase, ChangePOIOpenStatusUseCase changePOIOpenStatusUseCase) {
        this.addStaffMemberUseCase = addStaffMemberUseCase;
        this.removeStaffMemberUseCase = removeStaffMemberUseCase;
        this.changePOIOpenStatusUseCase = changePOIOpenStatusUseCase;
    }

    @PatchMapping("/changeOpenStatus")
    public void changeOpenStatus(
            @RequestParam String uuid,
            @RequestParam boolean open
    ) {
        changePOIOpenStatusUseCase.changeOpenStatus(UUID.fromString(uuid), open);
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
