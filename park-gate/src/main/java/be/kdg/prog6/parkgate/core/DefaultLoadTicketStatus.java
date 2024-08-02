package be.kdg.prog6.parkgate.core;

import be.kdg.prog6.parkgate.adapters.in.web.TicketController;
import be.kdg.prog6.parkgate.domain.Status;
import be.kdg.prog6.parkgate.ports.in.LoadTicketStatus;
import be.kdg.prog6.parkgate.ports.out.TicketStatusLoadedPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DefaultLoadTicketStatus implements LoadTicketStatus {
    private final TicketStatusLoadedPort ticketStatusLoadedPort;
    public static final Logger log = LoggerFactory.getLogger(TicketController.class);

    public DefaultLoadTicketStatus(TicketStatusLoadedPort ticketStatusLoadedPort) {
        this.ticketStatusLoadedPort = ticketStatusLoadedPort;
    }

    @Override
    public Status getTicketStatus(UUID ticketUUID) {
        return ticketStatusLoadedPort.getTicketStatus(ticketUUID);
    }
}
