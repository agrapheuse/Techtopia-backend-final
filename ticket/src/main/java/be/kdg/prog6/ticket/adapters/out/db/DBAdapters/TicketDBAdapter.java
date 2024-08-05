package be.kdg.prog6.ticket.adapters.out.db.DBAdapters;

import be.kdg.prog6.ticket.adapters.out.db.JPAEntities.TicketJpaEntity;
import be.kdg.prog6.ticket.adapters.out.db.repositories.TicketJpaRepository;
import be.kdg.prog6.ticket.domain.Ticket;
import be.kdg.prog6.ticket.ports.out.TicketCreatedPort;
import be.kdg.prog6.ticket.ports.out.TicketLoadPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TicketDBAdapter implements TicketCreatedPort, TicketLoadPort {
    private final TicketJpaRepository ticketJpaRepository;
    public static final Logger log = LoggerFactory.getLogger(TicketDBAdapter.class);

    public TicketDBAdapter(TicketJpaRepository ticketJpaRepository) {
        this.ticketJpaRepository = ticketJpaRepository;
    }

    private List<Ticket> convert(List<TicketJpaEntity> tickets) {
        if (tickets.isEmpty()) {
            return new ArrayList<>();
        }
        List<Ticket> result = new ArrayList<>();
        for (TicketJpaEntity ticket : tickets) {
            result.add(new Ticket(
                    new Ticket.TicketUuid(ticket.getUuid()),
                    ticket.getDate(),
                    ticket.getName(),
                    ticket.getAge(),
                    ticket.getGender(),
                    ticket.getTicketOption(),
                    ticket.getAgeType(),
                    ticket.getEmail())
            );
        }
        return result;
    }

    @Override
    public void createTicket(Ticket ticket) {
        log.debug("creating ticket {} called in db adapter", ticket.getUuid().uuid());
        TicketJpaEntity ticketJpaEntity = new TicketJpaEntity(
                ticket.getUuid().uuid(),
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

    @Override
    public List<Ticket> loadTicketsForEmail(String email) {
        List<TicketJpaEntity> tickets = ticketJpaRepository.findByEmailEquals(email);
        return convert(tickets);
    }
}
