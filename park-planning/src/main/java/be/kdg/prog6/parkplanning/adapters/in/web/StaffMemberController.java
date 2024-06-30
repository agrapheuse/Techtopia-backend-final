package be.kdg.prog6.parkplanning.adapters.in.web;

import be.kdg.prog6.parkplanning.ports.in.FindAllStaffMembersUseCase;
import be.kdg.prog6.parkplanning.ports.in.FindStaffMemberByNameUseCase;
import be.kdg.prog6.parkplanning.domain.StaffMember;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/staffMember")
public class StaffMemberController {
    private final FindAllStaffMembersUseCase findAllStaffMembersUseCase;
    private final FindStaffMemberByNameUseCase findStaffMemberByNameUseCase;

    public static final Logger log = LoggerFactory.getLogger(StaffMemberController.class);

    public StaffMemberController(FindAllStaffMembersUseCase findAllStaffMembersUseCase, FindStaffMemberByNameUseCase findStaffMemberByNameUseCase) {
        this.findAllStaffMembersUseCase = findAllStaffMembersUseCase;
        this.findStaffMemberByNameUseCase = findStaffMemberByNameUseCase;
    }

    @RequestMapping("")
    public List<StaffMember> getStaffMembers(
            @RequestParam Optional<String> name
    ) {
        if (name.isPresent()) {
            return findStaffMemberByNameUseCase.findStaffMemberByName(name.get());
        } else {
            return findAllStaffMembersUseCase.findAllStaffMembers();
        }
    }
}
