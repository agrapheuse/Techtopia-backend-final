package be.kdg.prog6.parkplanning.adapters.in.web;

import be.kdg.prog6.parkplanning.exceptions.POINotFoundException;
import be.kdg.prog6.parkplanning.ports.in.FindAllStaffMembersUseCase;
import be.kdg.prog6.parkplanning.ports.in.FindStaffMemberByNameUseCase;
import be.kdg.prog6.parkplanning.domain.StaffMember;
import be.kdg.prog6.parkplanning.ports.in.FindStaffMemberOfPOIUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/staffMember")
public class StaffMemberController {
    private final FindAllStaffMembersUseCase findAllStaffMembersUseCase;
    private final FindStaffMemberByNameUseCase findStaffMemberByNameUseCase;
    private final FindStaffMemberOfPOIUseCase findStaffMemberOfPOIUseCase;

    public static final Logger log = LoggerFactory.getLogger(StaffMemberController.class);

    public StaffMemberController(FindAllStaffMembersUseCase findAllStaffMembersUseCase, FindStaffMemberByNameUseCase findStaffMemberByNameUseCase, FindStaffMemberOfPOIUseCase findStaffMemberOfPOIUseCase) {
        this.findAllStaffMembersUseCase = findAllStaffMembersUseCase;
        this.findStaffMemberByNameUseCase = findStaffMemberByNameUseCase;
        this.findStaffMemberOfPOIUseCase = findStaffMemberOfPOIUseCase;
    }

    @RequestMapping("")
    public ResponseEntity<List<StaffMember>> getStaffMembers(
            @RequestParam Optional<String> name
    ) {
        try {
            if (name.isPresent()) {
                log.debug("get staff member with name {} called", name);
                List<StaffMember> staff = findStaffMemberByNameUseCase.findStaffMemberByName(name.get());
                return new ResponseEntity<>(staff, HttpStatus.OK);
            } else {
                log.debug("get all staff member called");
                List<StaffMember> staff = findAllStaffMembersUseCase.findAllStaffMembers();
                return new ResponseEntity<>(staff, HttpStatus.OK);

            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping("/staffOfPOI")
    public ResponseEntity<List<StaffMember>> getStaffMembersOfPOI(
            @RequestParam String uuid
    ) {
        log.debug("get staff member of poi {} called", uuid);
        try {
            List<StaffMember> staff = findStaffMemberOfPOIUseCase.findStaffMemberByPOI(UUID.fromString(uuid));
            return new ResponseEntity<>(staff, HttpStatus.OK);
        } catch (POINotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
