package be.kdg.prog6.ticket.core;

import be.kdg.prog6.ticket.domain.Ticket;
import be.kdg.prog6.ticket.ports.in.GetTicketsForAccountUseCase;
import be.kdg.prog6.ticket.ports.out.TicketLoadPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultGetTicketsForAccountUseCase implements GetTicketsForAccountUseCase {
    private final TicketLoadPort ticketLoadPort;
    public static final Logger log = LoggerFactory.getLogger(DefaultCreateTicketUseCase.class);

    public DefaultGetTicketsForAccountUseCase(TicketLoadPort ticketLoadPort) {
        this.ticketLoadPort = ticketLoadPort;
    }

    @Override
    public List<Ticket> getTicketsForAccount(String email) {
        log.debug("getting all tickets for account with email {} called in use case", email);
        return ticketLoadPort.loadTicketsForEmail(email);
    }
}
