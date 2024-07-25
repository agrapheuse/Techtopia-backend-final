package be.kdg.prog6.ticket.core;

import be.kdg.prog6.ticket.domain.Ticket;
import be.kdg.prog6.ticket.ports.in.CreateTicketCommand;
import be.kdg.prog6.ticket.ports.in.CreateTicketUseCase;
import be.kdg.prog6.ticket.ports.out.TicketCreatedPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DefaultCreateTicketUseCase implements CreateTicketUseCase {
    private final List<TicketCreatedPort> ticketCreatedPorts;
    public static final Logger log = LoggerFactory.getLogger(DefaultCreateTicketUseCase.class);

    public DefaultCreateTicketUseCase(List<TicketCreatedPort> ticketCreatedPorts) {
        this.ticketCreatedPorts = ticketCreatedPorts;
    }

    @Override
    public void createTicket(CreateTicketCommand createTicketCommand) {
            Ticket ticket = new Ticket(
                    new Ticket.TicketUuid(UUID.randomUUID()),
                    createTicketCommand.date(),
                    createTicketCommand.name(),
                    createTicketCommand.age(),
                    createTicketCommand.gender(),
                    createTicketCommand.ticketOption(),
                    createTicketCommand.ageType(),
                    createTicketCommand.email());
            ticketCreatedPorts.forEach(port -> port.createTicket(ticket));

    }
}
