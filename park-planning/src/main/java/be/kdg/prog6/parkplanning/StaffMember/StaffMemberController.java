package be.kdg.prog6.parkplanning.StaffMember;

import be.kdg.prog6.parkplanning.StaffMember.find.ports.FindAllStaffMembersUseCase;
import be.kdg.prog6.parkplanning.StaffMember.find.ports.FindStaffMemberByNameUseCase;
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
