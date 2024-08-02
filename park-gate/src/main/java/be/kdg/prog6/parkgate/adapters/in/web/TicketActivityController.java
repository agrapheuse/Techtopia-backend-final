package be.kdg.prog6.parkgate.adapters.in.web;

import be.kdg.prog6.parkgate.ports.in.EnterParkUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/ticketActivity")
public class TicketActivityController {
    private final EnterParkUseCase enterParkUseCase;
    public static final Logger log = LoggerFactory.getLogger(TicketController.class);

    public TicketActivityController(EnterParkUseCase enterParkUseCase) {
        this.enterParkUseCase = enterParkUseCase;
    }

    @PostMapping("/enter")
    public ResponseEntity<Void> enterPark(@RequestParam String ticketUUID) {
        log.debug("Entering park with ticket UUID: {}", ticketUUID);

        try {
            enterParkUseCase.enterPark(UUID.fromString(ticketUUID));
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error creating ticket activity", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //TODO: add exitPark && visitPOI
    /*
    @PostMapping("/exit")
    public ResponseEntity<Void> exitPark(@RequestParam String ticketUUID) {
        log.debug("exiting park with ticket UUID: {}", ticketUUID);

        try {
            createTicketActivityUseCase.createTicketActivity(new TicketActivity(
                    UUID.fromString(ticketUUID),
                    null,
                    ActivityType.EXITED,
                    LocalDateTime.now()
            ));
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error creating ticket activity", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/visitedPOI")
    public ResponseEntity<Void> visitPOI(
            @RequestParam String ticketUUID,
            @RequestParam String poiUUID
    ) {
        log.debug("ticket {} visiting POI {}", ticketUUID, poiUUID);

        try {
            createTicketActivityUseCase.createTicketActivity(new TicketActivity(
                    UUID.fromString(ticketUUID),
                    UUID.fromString(poiUUID),
                    ActivityType.EXITED,
                    LocalDateTime.now()
            ));
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error creating ticket activity", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/
}
