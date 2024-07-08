package be.kdg.prog6.parkgate.core;

import be.kdg.prog6.events.TicketCreatedEvent;
import be.kdg.prog6.parkgate.domain.Status;
import be.kdg.prog6.parkgate.domain.Ticket;
import be.kdg.prog6.parkgate.ports.in.CreateTicketUseCase;
import be.kdg.prog6.parkgate.ports.out.TicketCreatedPort;
import org.springframework.stereotype.Service;

@Service
public class DefaultCreateTicketUseCase implements CreateTicketUseCase {
    private final TicketCreatedPort ticketCreatedPort;

    public DefaultCreateTicketUseCase(TicketCreatedPort ticketCreatedPort) {
        this.ticketCreatedPort = ticketCreatedPort;
    }

    @Override
    public void createTicket(TicketCreatedEvent ticketCreatedEvent) {
        ticketCreatedPort.createTicket(
                new Ticket(
                        new Ticket.TicketUUID(ticketCreatedEvent.uuid()),
                        Status.NEW
                )
        );
    }
}
