package be.kdg.prog6.visitorInformationSystem.adapters.out.db.repository;

import be.kdg.prog6.visitorInformationSystem.adapters.out.db.entity.FoodStandJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FoodStandJpaRepository extends JpaRepository<FoodStandJpaEntity, UUID> {
    List<FoodStandJpaEntity> findByNameContainsIgnoreCase(String s);

    List<FoodStandJpaEntity> findByNameContainsIgnoreCaseAndOpenEquals(String s, boolean b);

    List<FoodStandJpaEntity> findByOpenEquals(boolean b);
}
