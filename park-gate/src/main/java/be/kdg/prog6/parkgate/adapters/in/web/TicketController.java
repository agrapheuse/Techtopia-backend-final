package be.kdg.prog6.parkgate.adapters.in.web;

import be.kdg.prog6.enums.Status;
import be.kdg.prog6.parkgate.exceptions.TicketNotFoundException;
import be.kdg.prog6.parkgate.ports.in.LoadTicketUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    private final LoadTicketUseCase loadTicketUseCase;
    public static final Logger log = LoggerFactory.getLogger(TicketController.class);

    public TicketController(LoadTicketUseCase loadTicketUseCase) {
        this.loadTicketUseCase = loadTicketUseCase;
    }

    @GetMapping("/ticketStatus")
    public ResponseEntity<Status> getTicketStatus(
            @RequestParam String ticketUUID
    ) {
        log.debug("fetching ticket status for ticket {}", ticketUUID);
        try {
            Status status = loadTicketUseCase.getTicket(UUID.fromString(ticketUUID)).getStatus();
            return new ResponseEntity<>(status, HttpStatus.OK);
        } catch (TicketNotFoundException e) {
            log.error("Error fetching ticket status, ticket not found", e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            log.error("Error fetching ticket status, internal server error", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
