package be.kdg.prog6.parkplanning.adapters.out.db.JPARepositories;

import be.kdg.prog6.parkplanning.adapters.out.db.JPAEntities.StaffMemberJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface StaffMemberJpaRepository extends JpaRepository<StaffMemberJpaEntity, UUID> {
    List<StaffMemberJpaEntity> findByNameContainsIgnoreCase(String name);
}
