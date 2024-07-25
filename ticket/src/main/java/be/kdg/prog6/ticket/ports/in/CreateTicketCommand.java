package be.kdg.prog6.ticket.ports.in;

import be.kdg.prog6.ticket.domain.Gender;
import be.kdg.prog6.ticket.domain.TicketAgeType;
import be.kdg.prog6.ticket.domain.TicketOption;

import java.time.LocalDate;

public record CreateTicketCommand(
        LocalDate date,
        String name,
        int age,
        Gender gender,
        TicketOption ticketOption,
        TicketAgeType ageType,
        String email
) {
}
