package be.kdg.prog6.ticket.adapters.out.db.DBAdapters;

import be.kdg.prog6.enums.Status;
import be.kdg.prog6.ticket.adapters.out.db.JPAEntities.TicketJpaEntity;
import be.kdg.prog6.ticket.adapters.out.db.repositories.TicketJpaRepository;
import be.kdg.prog6.ticket.domain.Ticket;
import be.kdg.prog6.ticket.exceptions.TicketNotFoundException;
import be.kdg.prog6.ticket.ports.out.TicketCreatedPort;
import be.kdg.prog6.ticket.ports.out.TicketLoadPort;
import be.kdg.prog6.ticket.ports.out.TicketUpdatedPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class TicketDBAdapter implements TicketCreatedPort, TicketLoadPort, TicketUpdatedPort {
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
                    ticket.getEmail(),
                    ticket.getStatus())
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
                ticket.getEmail(),
                ticket.getStatus()
        );
        ticketJpaRepository.save(ticketJpaEntity);
    }

    @Override
    public List<Ticket> loadTicketsForEmail(String email) {
        List<TicketJpaEntity> tickets = ticketJpaRepository.findByEmailEquals(email);
        return convert(tickets);
    }

    @Override
    public List<Ticket> loadTicketsForEmailAndStatus(String email, Status status) {
        List<TicketJpaEntity> tickets = ticketJpaRepository.findByEmailEqualsAndStatusEquals(email, status);
        return convert(tickets);
    }

    @Override
    public Ticket loadTicketForUUID(UUID uuid) {
        Optional<TicketJpaEntity> ticketJpa = ticketJpaRepository.findById(uuid);
        return ticketJpa.map(ticketJpaEntity -> new Ticket(
                new Ticket.TicketUuid(ticketJpaEntity.getUuid()),
                ticketJpaEntity.getDate(),
                ticketJpaEntity.getName(),
                ticketJpaEntity.getAge(),
                ticketJpaEntity.getGender(),
                ticketJpaEntity.getTicketOption(),
                ticketJpaEntity.getAgeType(),
                ticketJpaEntity.getEmail(),
                ticketJpaEntity.getStatus()
        )).orElseThrow(TicketNotFoundException::new);
    }

    @Override
    public void updateTicket(Ticket ticket) {
        TicketJpaEntity ticketJpa = new TicketJpaEntity(
                ticket.getUuid().uuid(),
                ticket.getDate(),
                ticket.getName(),
                ticket.getAge(),
                ticket.getGender(),
                ticket.getTicketOption(),
                ticket.getAgeType(),
                ticket.getEmail(),
                ticket.getStatus()
        );
        ticketJpaRepository.save(ticketJpa);
    }
}
