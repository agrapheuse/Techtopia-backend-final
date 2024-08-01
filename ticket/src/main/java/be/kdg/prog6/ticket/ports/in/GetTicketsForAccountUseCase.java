package be.kdg.prog6.ticket.ports.in;

import be.kdg.prog6.ticket.domain.Ticket;

import java.util.List;

public interface GetTicketsForAccountUseCase {
List<Ticket> getTicketsForAccount(String email);
}
