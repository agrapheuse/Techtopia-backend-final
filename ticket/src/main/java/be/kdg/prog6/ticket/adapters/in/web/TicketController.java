package be.kdg.prog6.ticket.adapters.in.web;

import be.kdg.prog6.ticket.domain.Gender;
import be.kdg.prog6.ticket.domain.TicketAgeType;
import be.kdg.prog6.ticket.domain.TicketOption;
import be.kdg.prog6.ticket.ports.in.CreateTicketCommand;
import be.kdg.prog6.ticket.ports.in.CreateTicketUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    private final CreateTicketUseCase createTicketUseCase;
    public static final Logger log = LoggerFactory.getLogger(TicketController.class);

    public TicketController(CreateTicketUseCase createTicketUseCase) {
        this.createTicketUseCase = createTicketUseCase;
    }

    @PostMapping("/create")
    public void createTicket(
            @RequestParam LocalDate date,
            @RequestParam String name,
            @RequestParam int age,
            @RequestParam Gender gender,
            @RequestParam String ticketOption,
            @RequestParam String ageType,
            @RequestParam String email
            ) {
        createTicketUseCase.createTicket(new CreateTicketCommand(
                date,
                name,
                age,
                gender,
                TicketOption.valueOf(ticketOption),
                TicketAgeType.valueOf(ageType),
                email
        ));
    }
}
