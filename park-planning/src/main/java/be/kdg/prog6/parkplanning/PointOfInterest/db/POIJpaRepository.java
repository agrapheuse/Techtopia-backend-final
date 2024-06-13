package be.kdg.prog6.parkplanning.PointOfInterest.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public interface POIJpaRepository extends JpaRepository<POIJpaEntity, UUID> {
    @Transactional
    @Modifying
    @Query("update POIJpaEntity p set p.open = true where p.uuid = ?1")
    void updateOpenByUuid(UUID uuid);

    @Transactional
    @Modifying
    @Query("update POIJpaEntity p set p.open = false where p.uuid = ?1")
    void updateCloseByUuid(UUID uuid);
}
