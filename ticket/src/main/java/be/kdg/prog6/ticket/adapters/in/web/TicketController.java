package be.kdg.prog6.ticket.adapters.in.web;

import be.kdg.prog6.ticket.domain.Ticket;
import be.kdg.prog6.ticket.ports.in.CreateTicketCommand;
import be.kdg.prog6.ticket.ports.in.CreateTicketUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    private final CreateTicketUseCase createTicketUseCase;
    public static final Logger log = LoggerFactory.getLogger(TicketController.class);

    public TicketController(CreateTicketUseCase createTicketUseCase) {
        this.createTicketUseCase = createTicketUseCase;
    }

    @PostMapping("/create")
    public void createTicket(@RequestBody Ticket ticket) {
        log.info(ticket.getTicketOption().toString());
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
}
