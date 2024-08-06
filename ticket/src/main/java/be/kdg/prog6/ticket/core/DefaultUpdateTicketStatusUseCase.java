package be.kdg.prog6.ticket.core;

import be.kdg.prog6.events.TicketStatusChangedEvent;
import be.kdg.prog6.ticket.domain.Ticket;
import be.kdg.prog6.ticket.exceptions.TicketNotFoundException;
import be.kdg.prog6.ticket.ports.in.UpdateTicketStatusUseCase;
import be.kdg.prog6.ticket.ports.out.TicketLoadPort;
import be.kdg.prog6.ticket.ports.out.TicketUpdatedPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DefaultUpdateTicketStatusUseCase implements UpdateTicketStatusUseCase {
    public static final Logger log = LoggerFactory.getLogger(DefaultUpdateTicketStatusUseCase.class);

    private final TicketLoadPort ticketLoadPort;
    private final TicketUpdatedPort ticketUpdatedPort;

    public DefaultUpdateTicketStatusUseCase(TicketLoadPort ticketLoadPort, TicketUpdatedPort ticketUpdatedPort) {
        this.ticketLoadPort = ticketLoadPort;
        this.ticketUpdatedPort = ticketUpdatedPort;
    }

    @Override
    public void updateTicket(TicketStatusChangedEvent ticketStatusChangedEvent) {
        try {
            Ticket ticket = ticketLoadPort.loadTicketForUUID(ticketStatusChangedEvent.TicketUUID());
            ticket.setStatus(ticketStatusChangedEvent.status());
            ticketUpdatedPort.updateTicket(ticket);
        } catch (TicketNotFoundException e) {
            log.error(e.getMessage());
        }
    }
}
