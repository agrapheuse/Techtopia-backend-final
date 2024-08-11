package be.kdg.prog6.parkplanning.adapters.out.db.JPARepositories;

import be.kdg.prog6.parkplanning.adapters.out.db.JPAEntities.ForecastJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

public interface ForecastJpaRepository extends JpaRepository<ForecastJpaEntity, UUID> {
    Optional<ForecastJpaEntity> findByDateEquals(LocalDate date);
}
