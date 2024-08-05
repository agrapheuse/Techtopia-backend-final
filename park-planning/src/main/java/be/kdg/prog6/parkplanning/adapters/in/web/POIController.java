package be.kdg.prog6.parkplanning.adapters.in.web;

import be.kdg.prog6.parkplanning.exceptions.POINotFoundException;
import be.kdg.prog6.parkplanning.exceptions.StaffMemberNotInPOIException;
import be.kdg.prog6.parkplanning.exceptions.StaffNotFoundException;
import be.kdg.prog6.parkplanning.ports.in.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pointOfInterest")
public class POIController {
    private final AddStaffMemberUseCase addStaffMemberUseCase;
    private final RemoveStaffMemberUseCase removeStaffMemberUseCase;
    private final ChangePOIOpenStatusUseCase changePOIOpenStatusUseCase;
    private final UpdateStaffMembersUseCase updateStaffMembersUseCase;

    public static final Logger log = LoggerFactory.getLogger(POIController.class);

    public POIController(AddStaffMemberUseCase addStaffMemberUseCase, RemoveStaffMemberUseCase removeStaffMemberUseCase, ChangePOIOpenStatusUseCase changePOIOpenStatusUseCase, UpdateStaffMembersUseCase updateStaffMembersUseCase) {
        this.addStaffMemberUseCase = addStaffMemberUseCase;
        this.removeStaffMemberUseCase = removeStaffMemberUseCase;
        this.changePOIOpenStatusUseCase = changePOIOpenStatusUseCase;
        this.updateStaffMembersUseCase = updateStaffMembersUseCase;
    }

    @PatchMapping("/changeOpenStatus")
    public ResponseEntity<Void> changeOpenStatus(
            @RequestParam String uuid,
            @RequestParam boolean open
    ) {
        log.debug("change open status called, POI with UUID {} will have its open status changed to {}", uuid, open);
        try {
            changePOIOpenStatusUseCase.changeOpenStatus(new ChangeOpenStatusCommand(UUID.fromString(uuid), open));
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (POINotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/updateStaffMembers")
    public ResponseEntity<Void> updateStaffMembers(
            @RequestParam String poiUuid,
            @RequestParam List<String> staffMemberUuids
    ) {
        log.debug("update staff members called, POI with UUID {} will have staff members {} assigned to it", poiUuid, staffMemberUuids);
        try {
            updateStaffMembersUseCase.updateStaffMembers(new UpdateStaffMemberCommand(
                    UUID.fromString(poiUuid),
                    staffMemberUuids.stream()
                            .map(UUID::fromString)
                            .collect(Collectors.toList())
            ));
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (StaffNotFoundException | POINotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




    @PatchMapping("/addStaffMember")
    public ResponseEntity<Void> addStaffMember(
            @RequestParam String poiUuid,
            @RequestParam String staffMemberUuid
    ) {
        log.debug("add staff member called, POI with UUID {} will have staff member with uuid {} assigned to it", poiUuid, staffMemberUuid);
        try {
            addStaffMemberUseCase.addStaffMember(new AddStaffMemberCommand(UUID.fromString(poiUuid), UUID.fromString(staffMemberUuid)));
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (StaffNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/removeStaffMember")
    public ResponseEntity<Void> removeStaffMember(
            @RequestParam String poiUuid,
            @RequestParam String staffMemberUuid
    ) {
        log.debug("remove staff member called, POI with UUID {} will have staff member with uuid {} removed from it", poiUuid, staffMemberUuid);
        try {
            removeStaffMemberUseCase.removeStaffMember(new RemoveStaffMemberCommand(UUID.fromString(poiUuid), UUID.fromString(staffMemberUuid)));
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (StaffNotFoundException | StaffMemberNotInPOIException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
