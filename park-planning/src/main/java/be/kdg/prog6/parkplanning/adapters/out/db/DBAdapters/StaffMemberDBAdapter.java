package be.kdg.prog6.parkplanning.adapters.out.db.DBAdapters;

import be.kdg.prog6.parkplanning.adapters.out.db.JPAEntities.StaffMemberJpaEntity;
import be.kdg.prog6.parkplanning.domain.StaffMember;
import be.kdg.prog6.parkplanning.adapters.out.db.JPARepositories.StaffMemberJpaRepository;
import be.kdg.prog6.parkplanning.ports.out.StaffMemberConversionPort;
import be.kdg.prog6.parkplanning.ports.out.StaffMemberLoadPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class StaffMemberDBAdapter implements StaffMemberLoadPort, StaffMemberConversionPort {
    private final StaffMemberJpaRepository staffMemberJpaRepository;
    public static final Logger log = LoggerFactory.getLogger(StaffMemberDBAdapter.class);

    public StaffMemberDBAdapter(StaffMemberJpaRepository staffMemberJpaRepository) {
        this.staffMemberJpaRepository = staffMemberJpaRepository;
    }

    public List<StaffMember> convert(List<StaffMemberJpaEntity> staffMembers) {
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

    @Override
    public StaffMember loadStaffMember(UUID uuid) {
        Optional<StaffMemberJpaEntity> staffMember = staffMemberJpaRepository.findById(uuid);
        //TODO: add exception: StaffMemberNotFoundException
        return staffMember.map(staffMemberJpaEntity -> new StaffMember(
                new StaffMember.StaffMemberUUID(staffMemberJpaEntity.getUuid()),
                staffMemberJpaEntity.getName()
        )).orElse(null);
    }
}