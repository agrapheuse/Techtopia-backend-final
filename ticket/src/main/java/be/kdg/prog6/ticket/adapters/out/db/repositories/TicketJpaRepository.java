package be.kdg.prog6.ticket.adapters.out.db.repositories;

import be.kdg.prog6.ticket.adapters.out.db.JPAEntities.TicketJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TicketJpaRepository extends JpaRepository<TicketJpaEntity, UUID> {
}
