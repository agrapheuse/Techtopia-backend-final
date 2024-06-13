package be.kdg.prog6.visitorInformationSystem.PointOfInterest.FoodStand.db;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FoodStandJpaRepository extends JpaRepository<FoodStandJpaEntity, UUID> {
    List<FoodStandJpaEntity> findByNameContainsIgnoreCase(String s);

    List<FoodStandJpaEntity> findByNameContainsIgnoreCaseAndOpenEquals(String s, boolean b);

    List<FoodStandJpaEntity> findByOpenEquals(boolean b);
}
