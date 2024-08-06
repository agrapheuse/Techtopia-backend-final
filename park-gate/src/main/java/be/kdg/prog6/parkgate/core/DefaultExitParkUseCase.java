package be.kdg.prog6.parkgate.core;

import be.kdg.prog6.parkgate.domain.ActivityType;
import be.kdg.prog6.enums.Status;
import be.kdg.prog6.parkgate.domain.Ticket;
import be.kdg.prog6.parkgate.domain.TicketActivity;
import be.kdg.prog6.parkgate.ports.in.ExitParkUseCase;
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
public class DefaultExitParkUseCase implements ExitParkUseCase {
    private final TicketLoadedPort ticketLoadedPort;
    private final List<TicketUpdatedPort> ticketUpdatedPorts;
    private final TicketActivityCreatedPort ticketActivityCreatedPort;
    public static final Logger log = LoggerFactory.getLogger(DefaultExitParkUseCase.class);

    public DefaultExitParkUseCase(TicketLoadedPort ticketLoadedPort, List<TicketUpdatedPort> ticketUpdatedPorts, TicketActivityCreatedPort ticketActivityCreatedPort) {
        this.ticketLoadedPort = ticketLoadedPort;
        this.ticketUpdatedPorts = ticketUpdatedPorts;
        this.ticketActivityCreatedPort = ticketActivityCreatedPort;
    }

    @Override
    public void exitPark(UUID ticketUUID) {
        log.debug("exit park with ticket {} called in DefaultEnterParkUseCase", ticketUUID);
        Ticket ticket = ticketLoadedPort.getTicket(ticketUUID);
        ticket.setStatus(Status.EXITED);
        ticketUpdatedPorts.forEach(p -> p.updateTicket(ticket));
        ticketActivityCreatedPort.createTicketActivity(
                new TicketActivity(
                        ticket.getUuid().uuid(),
                        null,
                        ActivityType.EXITED,
                        LocalDateTime.now()
                )
        );
    }
}
