package be.kdg.prog6.ticket.adapters.out.repositories;

import be.kdg.prog6.ticket.adapters.out.JPAEntities.TicketJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TicketJpaRepository extends JpaRepository<TicketJpaEntity, UUID> {
}
