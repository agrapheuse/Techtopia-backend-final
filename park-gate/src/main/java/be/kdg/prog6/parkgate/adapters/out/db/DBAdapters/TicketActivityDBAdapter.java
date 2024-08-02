package be.kdg.prog6.parkgate.adapters.out.db.DBAdapters;

import be.kdg.prog6.parkgate.adapters.out.db.JPAEntities.TicketActivityJpaEntity;
import be.kdg.prog6.parkgate.adapters.out.db.repositories.TicketActivityJpaRepository;
import be.kdg.prog6.parkgate.adapters.out.db.repositories.TicketJpaRepository;
import be.kdg.prog6.parkgate.domain.TicketActivity;
import be.kdg.prog6.parkgate.ports.out.TicketActivityCreatePort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class TicketActivityDBAdapter implements TicketActivityCreatePort {
    private final TicketActivityJpaRepository ticketActivityJpaRepository;
    public static final Logger log = LoggerFactory.getLogger(TicketDBAdapter.class);

    public TicketActivityDBAdapter(TicketActivityJpaRepository ticketActivityJpaRepository, TicketJpaRepository ticketJpaRepository) {
        this.ticketActivityJpaRepository = ticketActivityJpaRepository;
    }

    @Override
    public void createTicketActivity(TicketActivity ticketActivity) {
        TicketActivityJpaEntity ticketActivityJpaEntity = new TicketActivityJpaEntity(
                ticketActivity.ticketUUID(),
                ticketActivity.poiUUID(),
                ticketActivity.activityType(),
                ticketActivity.dateTime()
        );
        ticketActivityJpaRepository.save(ticketActivityJpaEntity);
    }
}
