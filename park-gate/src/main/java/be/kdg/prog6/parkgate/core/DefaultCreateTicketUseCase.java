package be.kdg.prog6.parkgate.core;

import be.kdg.prog6.events.TicketCreatedEvent;
import be.kdg.prog6.parkgate.domain.ActivityType;
import be.kdg.prog6.parkgate.domain.Status;
import be.kdg.prog6.parkgate.domain.Ticket;
import be.kdg.prog6.parkgate.domain.TicketActivity;
import be.kdg.prog6.parkgate.ports.in.CreateTicketUseCase;
import be.kdg.prog6.parkgate.ports.out.TicketActivityCreatePort;
import be.kdg.prog6.parkgate.ports.out.TicketCreatedPort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DefaultCreateTicketUseCase implements CreateTicketUseCase {
    private final TicketCreatedPort ticketCreatedPort;
    private final TicketActivityCreatePort ticketActivityCreatePort;

    public DefaultCreateTicketUseCase(TicketCreatedPort ticketCreatedPort, TicketActivityCreatePort ticketActivityCreatePort) {
        this.ticketCreatedPort = ticketCreatedPort;
        this.ticketActivityCreatePort = ticketActivityCreatePort;
    }

    @Override
    public void createTicket(TicketCreatedEvent ticketCreatedEvent) {
        ticketCreatedPort.createTicket(
                new Ticket(
                        new Ticket.TicketUUID(ticketCreatedEvent.uuid()),
                        Status.NEW
                )
        );
        ticketActivityCreatePort.createTicketActivity(new TicketActivity(
                ticketCreatedEvent.uuid(),
                null,
                ActivityType.CREATED,
                LocalDateTime.now()
        ));
    }
}
