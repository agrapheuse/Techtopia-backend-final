package be.kdg.prog6.parkplanning.PointOfInterest.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public interface POIJpaRepository extends JpaRepository<POIJpaEntity, UUID> {
    @Transactional
    @Modifying
    @Query("update POIJpaEntity p set p.open = ?2 where p.uuid = ?1")
    void updateOpenStatusByUuid(UUID uuid, boolean open);
}
