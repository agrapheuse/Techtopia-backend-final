package be.kdg.prog6.ticket.ports.in;

import be.kdg.prog6.enums.Status;
import be.kdg.prog6.ticket.domain.Ticket;

import java.util.List;

public interface GetTicketsForAccountAndStatusUseCase {
    List<Ticket> getTicketsForAccountAndStatus(String email, Status status);
}
