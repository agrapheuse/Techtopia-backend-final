package be.kdg.prog6.parkgate.core;

import be.kdg.prog6.parkgate.domain.Ticket;
import be.kdg.prog6.parkgate.ports.in.LoadTicketUseCase;
import be.kdg.prog6.parkgate.ports.out.TicketLoadedPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DefaultLoadTicketUseCase implements LoadTicketUseCase {
    private final TicketLoadedPort ticketLoadedPort;
    public static final Logger log = LoggerFactory.getLogger(DefaultLoadTicketUseCase.class);

    public DefaultLoadTicketUseCase(TicketLoadedPort ticketLoadedPort) {
        this.ticketLoadedPort = ticketLoadedPort;
    }

    @Override
    public Ticket getTicket(UUID ticketUUID) {
        log.debug("get ticket called in DefaultLoadTicketUseCase");
        return ticketLoadedPort.getTicket(ticketUUID);
    }
}
