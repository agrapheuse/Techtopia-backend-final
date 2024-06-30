package be.kdg.prog6.parkplanning.adapters.out.DBAdapters;

import be.kdg.prog6.parkplanning.domain.StaffMember;
import be.kdg.prog6.parkplanning.adapters.out.JPAEntities.StaffMemberJpaEntity;
import be.kdg.prog6.parkplanning.adapters.out.JPARepositories.StaffMemberJpaRepository;
import be.kdg.prog6.parkplanning.ports.out.StaffMemberLoadPort;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StaffMemberDBAdapter implements StaffMemberLoadPort {
    private final StaffMemberJpaRepository staffMemberJpaRepository;

    public StaffMemberDBAdapter(StaffMemberJpaRepository staffMemberJpaRepository) {
        this.staffMemberJpaRepository = staffMemberJpaRepository;
    }

    private List<StaffMember> convert(List<StaffMemberJpaEntity> staffMembers) {
        if (staffMembers.isEmpty()) {
            return new ArrayList<>();
        }
        List<StaffMember> result = new ArrayList<>();
        for (StaffMemberJpaEntity staffMember : staffMembers) {
            result.add(new StaffMember(new StaffMember.StaffMemberUUID(staffMember.getUuid()), staffMember.getName()));
        }
        return result;
    }

    @Override
    public List<StaffMember> loadAllStaffMembers() {
        return convert(staffMemberJpaRepository.findAll());
    }

    @Override
    public List<StaffMember> loadStaffMembersByName(String name) {
        return convert(staffMemberJpaRepository.findByNameContainsIgnoreCase(name));
    }
}
