package be.kdg.prog6.ticket.ports.in;

import be.kdg.prog6.ticket.domain.TicketAgeType;
import be.kdg.prog6.ticket.domain.TicketOption;

import java.time.LocalDate;
import java.util.UUID;

public record CreateTicketCommand(
        LocalDate date,
        UUID visitorUuid,
        TicketOption ticketOption,
        TicketAgeType ageType,
        String email
) {
}
