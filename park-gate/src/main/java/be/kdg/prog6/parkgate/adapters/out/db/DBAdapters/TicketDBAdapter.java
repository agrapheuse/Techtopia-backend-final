package be.kdg.prog6.parkgate.adapters.out.db.DBAdapters;

import be.kdg.prog6.parkgate.adapters.out.db.JPAEntities.TicketJpaEntity;
import be.kdg.prog6.parkgate.adapters.out.db.repositories.TicketJpaRepository;
import be.kdg.prog6.parkgate.domain.Ticket;
import be.kdg.prog6.parkgate.ports.out.TicketCreatedPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class TicketDBAdapter implements TicketCreatedPort {
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
}
