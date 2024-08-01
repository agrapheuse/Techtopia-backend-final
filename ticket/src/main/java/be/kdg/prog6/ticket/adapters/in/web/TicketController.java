package be.kdg.prog6.ticket.adapters.in.web;

import be.kdg.prog6.ticket.domain.Ticket;
import be.kdg.prog6.ticket.ports.in.CreateTicketCommand;
import be.kdg.prog6.ticket.ports.in.CreateTicketUseCase;
import be.kdg.prog6.ticket.ports.in.GetTicketsForAccountUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    private final CreateTicketUseCase createTicketUseCase;
    private final GetTicketsForAccountUseCase getTicketsForAccountUseCase;
    public static final Logger log = LoggerFactory.getLogger(TicketController.class);

    public TicketController(CreateTicketUseCase createTicketUseCase, GetTicketsForAccountUseCase getTicketsForAccountUseCase) {
        this.createTicketUseCase = createTicketUseCase;
        this.getTicketsForAccountUseCase = getTicketsForAccountUseCase;
    }

    @PostMapping("/create")
    public void createTicket(@RequestBody Ticket ticket) {
        createTicketUseCase.createTicket(new CreateTicketCommand(
                ticket.getDate(),
                ticket.getName(),
                ticket.getAge(),
                ticket.getGender(),
                ticket.getTicketOption(),
                ticket.getAgeType(),
                ticket.getEmail()
        ));
    }

    @GetMapping("/fetchByEmail")
    public List<Ticket> getAllTicketForAnAccount(@RequestParam String email) {
        log.debug("requested to get all tickets for the email: {}", email);
        return getTicketsForAccountUseCase.getTicketsForAccount(email);
    }
}
