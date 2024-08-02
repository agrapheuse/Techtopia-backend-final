package be.kdg.prog6.parkgate.core;

import be.kdg.prog6.parkgate.domain.TicketActivity;
import be.kdg.prog6.parkgate.ports.in.CreateTicketActivityUseCase;
import be.kdg.prog6.parkgate.ports.out.TicketActivityCreatedPort;
import org.springframework.stereotype.Service;

@Service
public class DefaultCreateTicketActivity implements CreateTicketActivityUseCase {
    private final TicketActivityCreatedPort ticketActivityCreatePort;

    public DefaultCreateTicketActivity(TicketActivityCreatedPort ticketActivityCreatePort) {
        this.ticketActivityCreatePort = ticketActivityCreatePort;
    }

    @Override
    public void createTicketActivity(TicketActivity ticketActivity) {
        ticketActivityCreatePort.createTicketActivity(ticketActivity);
    }
}
