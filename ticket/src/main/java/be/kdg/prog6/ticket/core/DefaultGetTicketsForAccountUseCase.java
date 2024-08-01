package be.kdg.prog6.ticket.core;

import be.kdg.prog6.ticket.domain.Ticket;
import be.kdg.prog6.ticket.ports.in.GetTicketsForAccountUseCase;
import be.kdg.prog6.ticket.ports.out.TicketLoadPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultGetTicketsForAccountUseCase implements GetTicketsForAccountUseCase {
    private final TicketLoadPort ticketLoadPort;

    public DefaultGetTicketsForAccountUseCase(TicketLoadPort ticketLoadPort) {
        this.ticketLoadPort = ticketLoadPort;
    }

    @Override
    public List<Ticket> getTicketsForAccount(String email) {
        return ticketLoadPort.loadTicketsForEmail(email);
    }
}
