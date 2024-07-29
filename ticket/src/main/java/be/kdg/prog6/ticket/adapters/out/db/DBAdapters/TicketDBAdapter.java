package be.kdg.prog6.ticket.adapters.out.db.DBAdapters;

import be.kdg.prog6.ticket.adapters.out.db.JPAEntities.TicketJpaEntity;
import be.kdg.prog6.ticket.adapters.out.db.repositories.TicketJpaRepository;
import be.kdg.prog6.ticket.domain.Ticket;
import be.kdg.prog6.ticket.ports.out.TicketCreatedPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.UUID;

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
                UUID.randomUUID(),
                ticket.getDate(),
                ticket.getName(),
                ticket.getAge(),
                ticket.getGender(),
                ticket.getTicketOption(),
                ticket.getAgeType(),
                ticket.getEmail()
        );
        ticketJpaRepository.save(ticketJpaEntity);
    }
}
