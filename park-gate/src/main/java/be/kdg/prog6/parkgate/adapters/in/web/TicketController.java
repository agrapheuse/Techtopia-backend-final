package be.kdg.prog6.parkgate.adapters.in.web;

import be.kdg.prog6.parkgate.domain.Status;
import be.kdg.prog6.parkgate.ports.in.LoadTicketStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    private final LoadTicketStatus loadTicketStatus;

    public TicketController(LoadTicketStatus loadTicketStatus) {
        this.loadTicketStatus = loadTicketStatus;
    }

    @GetMapping("/ticketStatus")
    public Status getTicketStatus(
            @RequestParam String ticketUUID
    ) {
        return loadTicketStatus.getTicketStatus(
                UUID.fromString(ticketUUID)
        );
    }
}
