package be.kdg.prog6.ticket.adapters.in.web;

import be.kdg.prog6.ticket.domain.Ticket;
import be.kdg.prog6.ticket.ports.in.CreateTicketCommand;
import be.kdg.prog6.ticket.ports.in.CreateTicketUseCase;
import be.kdg.prog6.ticket.ports.in.GetTicketsForAccountUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Void> createTicket(@RequestBody Ticket ticket) {
        log.debug("ticket controller called to create ticket for {}", ticket.getName());
        try {
            createTicketUseCase.createTicket(new CreateTicketCommand(
                    ticket.getDate(),
                    ticket.getName(),
                    ticket.getAge(),
                    ticket.getGender(),
                    ticket.getTicketOption(),
                    ticket.getAgeType(),
                    ticket.getEmail(),
                    ticket.getStatus()
            ));
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/fetchByEmail")
    public ResponseEntity<List<Ticket>> getAllTicketForAnAccount(@RequestParam String email) {
        log.debug("requested to get all tickets for the email: {}", email);
        try {
            List<Ticket> tickets = getTicketsForAccountUseCase.getTicketsForAccount(email);
            return new ResponseEntity<>(tickets, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/fetchByEmailAndStatus")
    public ResponseEntity<List<Ticket>> getAllTicketForAnAccountAndStatus(
            @RequestParam String email,
            @RequestParam String status
            ) {
        log.debug("requested to get all tickets for the email {} and status {}", email, status);
        try {
            List<Ticket> tickets = getTicketsForAccountUseCase.getTicketsForAccount(email);
            return new ResponseEntity<>(tickets, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
