package be.kdg.prog6.parkgate.adapters.out.db.DBAdapters;

import be.kdg.prog6.parkgate.adapters.out.db.JPAEntities.TicketActivityJpaEntity;
import be.kdg.prog6.parkgate.adapters.out.db.repositories.TicketActivityJpaRepository;
import be.kdg.prog6.parkgate.domain.ActivityType;
import be.kdg.prog6.parkgate.domain.Ticket;
import be.kdg.prog6.parkgate.domain.TicketActivity;
import be.kdg.prog6.parkgate.ports.out.TicketActivityCreatedPort;
import be.kdg.prog6.parkgate.ports.out.TicketCreatedPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class TicketActivityDBAdapter implements TicketCreatedPort, TicketActivityCreatedPort {
    private final TicketActivityJpaRepository ticketActivityJpaRepository;
    public static final Logger log = LoggerFactory.getLogger(TicketActivityDBAdapter.class);

    public TicketActivityDBAdapter(TicketActivityJpaRepository ticketActivityJpaRepository) {
        this.ticketActivityJpaRepository = ticketActivityJpaRepository;
    }

    @Override
    public void createTicket(Ticket ticket) {
        log.debug("saving create ticket activity for ticket {} in ticket activity db adapter", ticket.getUuid().uuid());
        TicketActivityJpaEntity ticketActivityJpaEntity = new TicketActivityJpaEntity(
                ticket.getUuid().uuid(),
                null,
                ActivityType.CREATED,
                LocalDateTime.now()
        );
        ticketActivityJpaRepository.save(ticketActivityJpaEntity);
    }

    @Override
    public void createTicketActivity(TicketActivity ticketActivity) {
        log.debug("saving ticket activity {} in ticket activity db adapter", ticketActivity.activityType());
        TicketActivityJpaEntity ticketActivityJpaEntity = new TicketActivityJpaEntity(
                ticketActivity.ticketUUID(),
                ticketActivity.poiUUID(),
                ticketActivity.activityType(),
                ticketActivity.dateTime()
        );
        ticketActivityJpaRepository.save(ticketActivityJpaEntity);
    }
}
