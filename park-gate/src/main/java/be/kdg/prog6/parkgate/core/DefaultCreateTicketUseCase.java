package be.kdg.prog6.parkgate.core;

import be.kdg.prog6.events.TicketCreatedEvent;
import be.kdg.prog6.parkgate.domain.ActivityType;
import be.kdg.prog6.parkgate.domain.Status;
import be.kdg.prog6.parkgate.domain.Ticket;
import be.kdg.prog6.parkgate.domain.TicketActivity;
import be.kdg.prog6.parkgate.ports.in.CreateTicketUseCase;
import be.kdg.prog6.parkgate.ports.out.TicketActivityCreatedPort;
import be.kdg.prog6.parkgate.ports.out.TicketCreatedPort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DefaultCreateTicketUseCase implements CreateTicketUseCase {
    private final List<TicketCreatedPort> ticketCreatedPorts;
    private final TicketActivityCreatedPort ticketActivityCreatePort;

    public DefaultCreateTicketUseCase(List<TicketCreatedPort> ticketCreatedPorts, TicketActivityCreatedPort ticketActivityCreatePort) {
        this.ticketCreatedPorts = ticketCreatedPorts;
        this.ticketActivityCreatePort = ticketActivityCreatePort;
    }

    @Override
    public void createTicket(TicketCreatedEvent ticketCreatedEvent) {
        ticketCreatedPorts.forEach(port -> port.createTicket(
                new Ticket(
                        new Ticket.TicketUUID(ticketCreatedEvent.uuid()),
                        Status.NEW
                )
        ));

        ticketActivityCreatePort.createTicketActivity(new TicketActivity(
                ticketCreatedEvent.uuid(),
                null,
                ActivityType.CREATED,
                LocalDateTime.now()
        ));
    }
}
