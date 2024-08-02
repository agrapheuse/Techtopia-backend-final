package be.kdg.prog6.parkgate.adapters.in.web;

import be.kdg.prog6.parkgate.domain.ActivityType;
import be.kdg.prog6.parkgate.domain.TicketActivity;
import be.kdg.prog6.parkgate.ports.in.CreateTicketActivityUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/ticketActivity")
public class TicketActivityController {
    private final CreateTicketActivityUseCase createTicketActivityUseCase;

    public TicketActivityController(CreateTicketActivityUseCase createTicketActivityUseCase) {
        this.createTicketActivityUseCase = createTicketActivityUseCase;
    }

    @PostMapping("/enter")
    public void enterPark(
            @RequestParam String ticketUUID
    ) {
        createTicketActivityUseCase.createTicketActivity(new TicketActivity(
                UUID.fromString(ticketUUID),
                null,
                ActivityType.ENTERED,
                LocalDateTime.now()
        ));
    }

    @PostMapping("/exit")
    public void exitPark(
            @RequestParam String ticketUUID
    ) {
        createTicketActivityUseCase.createTicketActivity(new TicketActivity(
                UUID.fromString(ticketUUID),
                null,
                ActivityType.EXITED,
                LocalDateTime.now()
        ));
    }

    @PostMapping("/visitedPOI")
    public void visitPOI(
            @RequestParam String ticketUUID,
            @RequestParam String poiUUID
    ) {
        createTicketActivityUseCase.createTicketActivity(new TicketActivity(
                UUID.fromString(ticketUUID),
                UUID.fromString(poiUUID),
                ActivityType.EXITED,
                LocalDateTime.now()
        ));
    }
}
