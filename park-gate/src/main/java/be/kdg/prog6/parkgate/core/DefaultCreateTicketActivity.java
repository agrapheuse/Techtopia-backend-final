package be.kdg.prog6.parkgate.core;

import be.kdg.prog6.parkgate.domain.TicketActivity;
import be.kdg.prog6.parkgate.ports.in.CreateTicketActivityUseCase;
import org.springframework.stereotype.Service;

@Service
public class DefaultCreateTicketActivity implements CreateTicketActivityUseCase {
    @Override
    public void createTicketActivity(TicketActivity ticketActivity) {

    }
}
