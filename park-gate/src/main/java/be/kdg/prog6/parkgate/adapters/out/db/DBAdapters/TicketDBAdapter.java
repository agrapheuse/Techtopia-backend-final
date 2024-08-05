package be.kdg.prog6.parkgate.adapters.out.db.DBAdapters;

import be.kdg.prog6.parkgate.adapters.out.db.JPAEntities.TicketJpaEntity;
import be.kdg.prog6.parkgate.adapters.out.db.repositories.TicketJpaRepository;
import be.kdg.prog6.parkgate.domain.Ticket;
import be.kdg.prog6.parkgate.exceptions.TicketNotFoundException;
import be.kdg.prog6.parkgate.ports.out.TicketCreatedPort;
import be.kdg.prog6.parkgate.ports.out.TicketLoadedPort;
import be.kdg.prog6.parkgate.ports.out.TicketUpdatedPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class TicketDBAdapter implements TicketCreatedPort, TicketLoadedPort, TicketUpdatedPort {
    private final TicketJpaRepository ticketJpaRepository;
    public static final Logger log = LoggerFactory.getLogger(TicketDBAdapter.class);

    public TicketDBAdapter(TicketJpaRepository ticketJpaRepository) {
        this.ticketJpaRepository = ticketJpaRepository;
    }

    @Override
    public void createTicket(Ticket ticket) {
        log.debug("creating ticket {} in ticket db adapter", ticket.getUuid().uuid());
        TicketJpaEntity ticketJpaEntity = new TicketJpaEntity(
                ticket.getUuid().uuid(),
                ticket.getStatus()
        );
        ticketJpaRepository.save(ticketJpaEntity);
    }

    @Override
    public Ticket getTicket(UUID ticketUUID) {
        log.debug("loading ticket {} in ticket db adapter", ticketUUID);
        Optional<TicketJpaEntity> ticket = ticketJpaRepository.findById(ticketUUID);
        return ticket.map(ticketJpaEntity -> new Ticket(
                new Ticket.TicketUUID(ticketJpaEntity.getUuid()),
                ticketJpaEntity.getStatus()
        )).orElseThrow(TicketNotFoundException::new);
    }

    @Override
    public void updateTicket(Ticket ticket) {
        log.debug("{}, {}", ticket.getUuid(), ticket.getStatus());
        ticketJpaRepository.save(
                new TicketJpaEntity(
                        ticket.getUuid().uuid(),
                        ticket.getStatus()
                )
        );
    }
}
