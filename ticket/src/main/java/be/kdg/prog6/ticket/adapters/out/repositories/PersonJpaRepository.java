package be.kdg.prog6.ticket.adapters.out.repositories;

import be.kdg.prog6.ticket.adapters.out.JPAEntities.PersonJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PersonJpaRepository extends JpaRepository<PersonJpaEntity, UUID> {
}
