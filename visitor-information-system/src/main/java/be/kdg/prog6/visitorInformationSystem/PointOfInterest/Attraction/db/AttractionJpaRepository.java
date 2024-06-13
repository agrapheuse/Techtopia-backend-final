package be.kdg.prog6.visitorInformationSystem.PointOfInterest.Attraction.db;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AttractionJpaRepository extends JpaRepository<AttractionJpaEntity, UUID> {
    List<AttractionJpaEntity> findByNameContainsIgnoreCase(String s);

    List<AttractionJpaEntity> findByNameContainsIgnoreCaseAndOpenEquals(String s, boolean b);

    List<AttractionJpaEntity> findByOpenEquals(boolean b);
}
