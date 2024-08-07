package be.kdg.prog6.parkgate.adapters.in.web;

import be.kdg.prog6.parkgate.exceptions.TicketNotFoundException;
import be.kdg.prog6.parkgate.ports.in.*;
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
    private final ExitParkUseCase exitParkUseCase;
    private final VisitPOIUseCase visitPOIUseCase;
    public static final Logger log = LoggerFactory.getLogger(TicketActivityController.class);

    public TicketActivityController(EnterParkUseCase enterParkUseCase, ExitParkUseCase exitParkUseCase, VisitPOIUseCase visitPOIUseCase) {
        this.enterParkUseCase = enterParkUseCase;
        this.exitParkUseCase = exitParkUseCase;
        this.visitPOIUseCase = visitPOIUseCase;
    }

    @PostMapping("/enter")
    public ResponseEntity<Void> enterPark(@RequestParam String ticketUUID) {
        log.debug("Entering park with ticket UUID: {}", ticketUUID);

        try {
            enterParkUseCase.enterPark(UUID.fromString(ticketUUID));
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (TicketNotFoundException e) {
            log.error("Error creating ticket activity, ticket not found", e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            log.error("Error creating ticket activity, internal server error", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/exit")
    public ResponseEntity<Void> exitPark(@RequestParam String ticketUUID) {
        log.debug("Exiting park with ticket UUID: {}", ticketUUID);

        try {
            exitParkUseCase.exitPark(UUID.fromString(ticketUUID));
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (TicketNotFoundException e) {
            log.error("Error creating ticket activity, ticket not found", e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            log.error("Error creating ticket activity, internal server error", e);
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
            visitPOIUseCase.visitPOI(new VisitPOICommand(
                    UUID.fromString(ticketUUID),
                    UUID.fromString(poiUUID)
            ));
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error creating ticket activity", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
