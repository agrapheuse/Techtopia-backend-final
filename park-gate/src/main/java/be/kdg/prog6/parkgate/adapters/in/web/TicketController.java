package be.kdg.prog6.parkgate.adapters.in.web;

import be.kdg.prog6.parkgate.domain.Status;
import be.kdg.prog6.parkgate.ports.in.LoadTicketUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    public Status getTicketStatus(
            @RequestParam String ticketUUID
    ) {
        return loadTicketUseCase.getTicket(UUID.fromString(ticketUUID)).getStatus();
    }
}
