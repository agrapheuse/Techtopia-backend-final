package be.kdg.prog6.ticket.core;

import be.kdg.prog6.ticket.domain.Person;
import be.kdg.prog6.ticket.domain.Ticket;
import be.kdg.prog6.ticket.ports.in.CreateTicketCommand;
import be.kdg.prog6.ticket.ports.in.CreateTicketUseCase;
import be.kdg.prog6.ticket.ports.out.PersonLoadPort;
import be.kdg.prog6.ticket.ports.out.TicketCreatedPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DefaultCreateTicketUseCase implements CreateTicketUseCase {
    private final PersonLoadPort personLoadPort;
    private final List<TicketCreatedPort> ticketCreatedPorts;
    public static final Logger log = LoggerFactory.getLogger(DefaultCreateTicketUseCase.class);

    public DefaultCreateTicketUseCase(PersonLoadPort personLoadPort, List<TicketCreatedPort> ticketCreatedPorts) {
        this.personLoadPort = personLoadPort;
        this.ticketCreatedPorts = ticketCreatedPorts;
    }

    @Override
    public void createTicket(CreateTicketCommand createTicketCommand) {
        Optional<Person> person = personLoadPort.loadPerson(createTicketCommand.visitorUuid());
        if (person.isPresent()) {
            Ticket ticket = new Ticket(
                    new Ticket.TicketUuid(UUID.randomUUID()),
                    createTicketCommand.date(),
                    person.get(),
                    createTicketCommand.ticketOption(),
                    createTicketCommand.ageType(),
                    createTicketCommand.email());
            ticketCreatedPorts.forEach(port -> port.createTicket(ticket));
        }
    }
}
