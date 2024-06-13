package be.kdg.prog6.parkplanning.StaffMember.db;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface StaffMemberJpaRepository extends JpaRepository<StaffMemberJpaEntity, UUID> {
    public List<StaffMemberJpaEntity> findByNameContainsIgnoreCase(String name);
}
