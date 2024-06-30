package be.kdg.prog6.ticket.core;

import be.kdg.prog6.ticket.domain.Person;
import be.kdg.prog6.ticket.domain.Ticket;
import be.kdg.prog6.ticket.ports.in.CreateTicketCommand;
import be.kdg.prog6.ticket.ports.in.CreateTicketUseCase;
import be.kdg.prog6.ticket.ports.out.PersonLoadPort;
import be.kdg.prog6.ticket.ports.out.TicketCreatedPort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DefaultCreateTicketUseCase implements CreateTicketUseCase {
    private final PersonLoadPort personLoadPort;
    private final TicketCreatedPort createTicket;

    public DefaultCreateTicketUseCase(PersonLoadPort personLoadPort, TicketCreatedPort createTicket) {
        this.personLoadPort = personLoadPort;
        this.createTicket = createTicket;
    }

    @Override
    public void createTicket(CreateTicketCommand createTicketCommand) {
        Optional<Person> person = personLoadPort.loadPerson(createTicketCommand.visitorUuid());
        if (person.isPresent()) {
            Ticket ticket = new Ticket(
                    createTicketCommand.date(),
                    person.get(),
                    createTicketCommand.ticketOption(),
                    createTicketCommand.ageType(),
                    createTicketCommand.email()
            );
            createTicket.createTicket(ticket);
        }
    }
}
