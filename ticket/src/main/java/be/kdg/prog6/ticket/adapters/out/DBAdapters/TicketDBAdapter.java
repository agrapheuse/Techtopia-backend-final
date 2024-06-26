package be.kdg.prog6.ticket.adapters.out.DBAdapters;

import be.kdg.prog6.ticket.adapters.out.JPAEntities.PersonJpaEntity;
import be.kdg.prog6.ticket.adapters.out.JPAEntities.TicketJpaEntity;
import be.kdg.prog6.ticket.adapters.out.repositories.TicketJpaRepository;
import be.kdg.prog6.ticket.domain.Ticket;
import be.kdg.prog6.ticket.ports.out.TicketCreatedPort;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class TicketDBAdapter implements TicketCreatedPort {
    private final TicketJpaRepository ticketJpaRepository;

    public TicketDBAdapter(TicketJpaRepository ticketJpaRepository) {
        this.ticketJpaRepository = ticketJpaRepository;
    }

    @Override
    public void createTicket(Ticket ticket) {
        PersonJpaEntity person = new PersonJpaEntity(
                ticket.getVisitor().getUuid().uuid(),
                ticket.getVisitor().getName(),
                ticket.getVisitor().getSex(),
                ticket.getVisitor().getAge()
        );
        TicketJpaEntity ticketJpaEntity = new TicketJpaEntity(
                UUID.randomUUID(),
                ticket.getDate(),
                person,
                ticket.getOption(),
                ticket.getAgeType(),
                ticket.getEmail()
        );
        ticketJpaRepository.save(ticketJpaEntity);
    }
}
