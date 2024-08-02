package be.kdg.prog6.parkgate.ports.out;

import be.kdg.prog6.parkgate.domain.TicketActivity;

public interface TicketActivityCreatedPort {
    void createTicketActivity(TicketActivity ticketActivity);
}
