package be.kdg.prog6.parkgate.core;

import be.kdg.prog6.parkgate.domain.ActivityType;
import be.kdg.prog6.parkgate.domain.Status;
import be.kdg.prog6.parkgate.domain.Ticket;
import be.kdg.prog6.parkgate.domain.TicketActivity;
import be.kdg.prog6.parkgate.ports.in.EnterParkUseCase;
import be.kdg.prog6.parkgate.ports.out.TicketActivityCreatedPort;
import be.kdg.prog6.parkgate.ports.out.TicketLoadedPort;
import be.kdg.prog6.parkgate.ports.out.TicketUpdatedPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class DefaultEnterParkUseCase implements EnterParkUseCase {
    private final TicketUpdatedPort ticketUpdatedPort;
    private final TicketLoadedPort ticketLoadedPort;
    private final TicketActivityCreatedPort ticketActivityCreatedPort;
    public static final Logger log = LoggerFactory.getLogger(DefaultEnterParkUseCase.class);

    public DefaultEnterParkUseCase(TicketUpdatedPort ticketUpdatedPort, TicketLoadedPort ticketLoadedPort, TicketActivityCreatedPort ticketActivityCreatedPort) {
        this.ticketUpdatedPort = ticketUpdatedPort;
        this.ticketLoadedPort = ticketLoadedPort;
        this.ticketActivityCreatedPort = ticketActivityCreatedPort;
    }

    @Override
    public void enterPark(UUID ticketUUID) {
        log.debug("enter park with ticket {} called in DefaultEnterParkUseCase", ticketUUID);
        Ticket ticket = ticketLoadedPort.getTicket(ticketUUID);
        ticket.setStatus(Status.ENTERED);
        ticketUpdatedPort.updateTicket(ticket);
        ticketActivityCreatedPort.createTicketActivity(
                new TicketActivity(
                        ticket.getUuid().uuid(),
                        null,
                        ActivityType.ENTERED,
                        LocalDateTime.now()
                )
        );
    }
}
