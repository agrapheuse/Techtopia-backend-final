package be.kdg.prog6.parkgate.core;

import be.kdg.prog6.events.TicketCreatedEvent;
import be.kdg.prog6.parkgate.domain.ActivityType;
import be.kdg.prog6.enums.Status;
import be.kdg.prog6.parkgate.domain.Ticket;
import be.kdg.prog6.parkgate.domain.TicketActivity;
import be.kdg.prog6.parkgate.ports.in.CreateTicketUseCase;
import be.kdg.prog6.parkgate.ports.out.TicketActivityCreatedPort;
import be.kdg.prog6.parkgate.ports.out.TicketCreatedPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DefaultCreateTicketUseCase implements CreateTicketUseCase {
    private final List<TicketCreatedPort> ticketCreatedPorts;
    private final List<TicketActivityCreatedPort> ticketActivityCreatePorts;
    public static final Logger log = LoggerFactory.getLogger(DefaultCreateTicketUseCase.class);

    public DefaultCreateTicketUseCase(List<TicketCreatedPort> ticketCreatedPorts, List<TicketActivityCreatedPort> ticketActivityCreatePorts) {
        this.ticketCreatedPorts = ticketCreatedPorts;
        this.ticketActivityCreatePorts = ticketActivityCreatePorts;
    }

    @Override
    public void createTicket(TicketCreatedEvent ticketCreatedEvent) {
        log.debug("create ticket {} called in DefaultCreateTicketUseCase", ticketCreatedEvent.uuid());
        ticketCreatedPorts.forEach(port -> port.createTicket(
                new Ticket(
                        new Ticket.TicketUUID(ticketCreatedEvent.uuid()),
                        Status.NEW
                )
        ));

        ticketActivityCreatePorts.forEach(p -> p.createTicketActivity(new TicketActivity(
                ticketCreatedEvent.uuid(),
                null,
                ActivityType.CREATED,
                LocalDateTime.now()
        )));
    }
}
