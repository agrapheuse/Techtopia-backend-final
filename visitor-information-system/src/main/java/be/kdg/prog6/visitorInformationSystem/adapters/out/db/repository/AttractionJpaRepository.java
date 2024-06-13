package be.kdg.prog6.visitorInformationSystem.adapters.out.db.repository;

import be.kdg.prog6.visitorInformationSystem.adapters.out.db.entity.AttractionJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AttractionJpaRepository extends JpaRepository<AttractionJpaEntity, UUID> {
    List<AttractionJpaEntity> findByNameContainsIgnoreCase(String s);

    List<AttractionJpaEntity> findByNameContainsIgnoreCaseAndOpenEquals(String s, boolean b);

    List<AttractionJpaEntity> findByOpenEquals(boolean b);
}
