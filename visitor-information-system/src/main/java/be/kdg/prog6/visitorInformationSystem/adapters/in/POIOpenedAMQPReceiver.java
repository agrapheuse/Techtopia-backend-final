package be.kdg.prog6.visitorInformationSystem.adapters.in;

import be.kdg.prog6.events.PointOfInterestOpenStatusChangedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class POIOpenedAMQPReceiver {
    public static final Logger log = LoggerFactory.getLogger(POIOpenedAMQPReceiver.class);

    @EventListener
    public void handle(PointOfInterestOpenStatusChangedEvent pointOfInterestOpenedEvent) {
        log.info("event received, changing status of " + pointOfInterestOpenedEvent.POIUuid() + "to " + pointOfInterestOpenedEvent.open());
    }
}
