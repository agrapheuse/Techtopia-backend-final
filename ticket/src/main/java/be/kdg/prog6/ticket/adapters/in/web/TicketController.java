package be.kdg.prog6.ticket.adapters.in.web;

import be.kdg.prog6.ticket.domain.TicketAgeType;
import be.kdg.prog6.ticket.domain.TicketOption;
import be.kdg.prog6.ticket.ports.in.CreateTicketCommand;
import be.kdg.prog6.ticket.ports.in.CreateTicketUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.UUID;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    private final CreateTicketUseCase createTicketUseCase;

    public TicketController(CreateTicketUseCase createTicketUseCase) {
        this.createTicketUseCase = createTicketUseCase;
    }

    @PostMapping("/create")
    public void createTicket(
            @RequestParam LocalDate date,
            @RequestParam UUID visitorUuid,
            @RequestParam String ticketOption,
            @RequestParam String ageType,
            @RequestParam String email
            ) {
        createTicketUseCase.createTicket(new CreateTicketCommand(
                date,
                visitorUuid,
                TicketOption.valueOf(ticketOption),
                TicketAgeType.valueOf(ageType),
                email
        ));
    }
}
