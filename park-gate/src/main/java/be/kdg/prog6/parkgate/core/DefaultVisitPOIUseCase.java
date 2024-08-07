package be.kdg.prog6.parkgate.core;

import be.kdg.prog6.parkgate.adapters.in.web.TicketActivityController;
import be.kdg.prog6.parkgate.domain.ActivityType;
import be.kdg.prog6.parkgate.domain.TicketActivity;
import be.kdg.prog6.parkgate.ports.in.VisitPOICommand;
import be.kdg.prog6.parkgate.ports.in.VisitPOIUseCase;
import be.kdg.prog6.parkgate.ports.out.TicketActivityCreatedPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DefaultVisitPOIUseCase implements VisitPOIUseCase {
    public static final Logger log = LoggerFactory.getLogger(DefaultVisitPOIUseCase.class);

    private final List<TicketActivityCreatedPort> ticketActivityCreatedPorts;

    public DefaultVisitPOIUseCase(List<TicketActivityCreatedPort> ticketActivityCreatedPorts) {
        this.ticketActivityCreatedPorts = ticketActivityCreatedPorts;
    }

    @Override
    public void visitPOI(VisitPOICommand visitPOICommand) {
        log.debug("visit POI {} with ticket {}", visitPOICommand.poiUUID(), visitPOICommand.ticketUUID());
        ticketActivityCreatedPorts.forEach(p -> p.createTicketActivity(
                new TicketActivity(
                        visitPOICommand.ticketUUID(),
                        visitPOICommand.poiUUID(),
                        ActivityType.POI,
                        LocalDateTime.now()
                ))
        );
    }
}
