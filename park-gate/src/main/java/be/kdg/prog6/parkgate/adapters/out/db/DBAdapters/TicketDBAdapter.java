package be.kdg.prog6.parkgate.adapters.out.db.DBAdapters;

import be.kdg.prog6.parkgate.adapters.out.db.JPAEntities.TicketJpaEntity;
import be.kdg.prog6.parkgate.adapters.out.db.repositories.TicketJpaRepository;
import be.kdg.prog6.parkgate.domain.Status;
import be.kdg.prog6.parkgate.domain.Ticket;
import be.kdg.prog6.parkgate.ports.out.TicketCreatedPort;
import be.kdg.prog6.parkgate.ports.out.TicketStatusLoadedPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class TicketDBAdapter implements TicketCreatedPort, TicketStatusLoadedPort {
    private final TicketJpaRepository ticketJpaRepository;
    public static final Logger log = LoggerFactory.getLogger(TicketDBAdapter.class);

    public TicketDBAdapter(TicketJpaRepository ticketJpaRepository) {
        this.ticketJpaRepository = ticketJpaRepository;
    }

    @Override
    public void createTicket(Ticket ticket) {
        TicketJpaEntity ticketJpaEntity = new TicketJpaEntity(
                ticket.getUuid().uuid(),
                ticket.getStatus()
        );
        ticketJpaRepository.save(ticketJpaEntity);
    }

    @Override
    public Status getTicketStatus(UUID ticketUUID) {
        Optional<TicketJpaEntity> ticket = ticketJpaRepository.findById(ticketUUID);
        //TODO: add TicketNotFoundException
        return ticket.map(TicketJpaEntity::getStatus).orElse(null);
    }
}
