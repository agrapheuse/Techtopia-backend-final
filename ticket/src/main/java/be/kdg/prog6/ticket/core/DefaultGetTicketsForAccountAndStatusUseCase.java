package be.kdg.prog6.ticket.core;

import be.kdg.prog6.enums.Status;
import be.kdg.prog6.ticket.domain.Ticket;
import be.kdg.prog6.ticket.ports.in.GetTicketsForAccountAndStatusUseCase;
import be.kdg.prog6.ticket.ports.out.TicketLoadPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultGetTicketsForAccountAndStatusUseCase implements GetTicketsForAccountAndStatusUseCase {
    public static final Logger log = LoggerFactory.getLogger(DefaultGetTicketsForAccountAndStatusUseCase.class);

    private final TicketLoadPort ticketLoadPort;

    public DefaultGetTicketsForAccountAndStatusUseCase(TicketLoadPort ticketLoadPort) {
        this.ticketLoadPort = ticketLoadPort;
    }

    @Override
    public List<Ticket> getTicketsForAccountAndStatus(String email, Status status) {
        log.debug("get tickets for email {} and status {} called in use case", email, status);
        return ticketLoadPort.loadTicketsForEmailAndStatus(email, status);
    }
}
