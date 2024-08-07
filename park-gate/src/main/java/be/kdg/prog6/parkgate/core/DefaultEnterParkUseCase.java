package be.kdg.prog6.parkgate.core;

import be.kdg.prog6.parkgate.domain.ActivityType;
import be.kdg.prog6.enums.Status;
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
import java.util.List;
import java.util.UUID;

@Service
public class DefaultEnterParkUseCase implements EnterParkUseCase {
    private final List<TicketUpdatedPort> ticketUpdatedPorts;
    private final TicketLoadedPort ticketLoadedPort;
    private final List<TicketActivityCreatedPort> ticketActivityCreatedPorts;
    public static final Logger log = LoggerFactory.getLogger(DefaultEnterParkUseCase.class);

    public DefaultEnterParkUseCase(List<TicketUpdatedPort> ticketUpdatedPorts, TicketLoadedPort ticketLoadedPort, List<TicketActivityCreatedPort> ticketActivityCreatedPorts) {
        this.ticketUpdatedPorts = ticketUpdatedPorts;
        this.ticketLoadedPort = ticketLoadedPort;
        this.ticketActivityCreatedPorts = ticketActivityCreatedPorts;
    }

    @Override
    public void enterPark(UUID ticketUUID) {
        log.debug("enter park with ticket {} called in DefaultEnterParkUseCase", ticketUUID);
        Ticket ticket = ticketLoadedPort.getTicket(ticketUUID);
        ticket.setStatus(Status.ENTERED);
        ticketUpdatedPorts.forEach(p -> p.updateTicket(ticket));
        ticketActivityCreatedPorts.forEach(p -> p.createTicketActivity(
                new TicketActivity(
                        ticket.getUuid().uuid(),
                        null,
                        ActivityType.ENTERED,
                        LocalDateTime.now()
                )
        ));
    }
}
